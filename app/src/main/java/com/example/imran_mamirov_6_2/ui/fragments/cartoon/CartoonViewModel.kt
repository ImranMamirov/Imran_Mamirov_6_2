package com.example.imran_mamirov_6_2.ui.fragments.cartoon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imran_mamirov_6_2.data.model.Character
import com.example.imran_mamirov_6_2.data.repository.Repository
import com.example.imran_mamirov_6_2.utils.Resource
import kotlinx.coroutines.launch

class CartoonViewModel (private val repository: Repository) : ViewModel() {

    private val _characters = MutableLiveData<Resource<List<Character>>>()
    val characters: LiveData<Resource<List<Character>>> get() = _characters

    init {
        fetchedCharacter()
    }

    private fun fetchedCharacter() {
        viewModelScope.launch {
            repository.getAllCharacters().observeForever { characters ->
                _characters.postValue(characters)
            }
        }
    }
}