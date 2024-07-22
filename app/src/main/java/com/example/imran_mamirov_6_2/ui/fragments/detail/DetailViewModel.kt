package com.example.imran_mamirov_6_2.ui.fragments.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.imran_mamirov_6_2.data.model.Character
import com.example.imran_mamirov_6_2.data.repository.Repository
import com.example.imran_mamirov_6_2.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    fun getById(id: Int): LiveData<Resource<Character>> = repository.getCharacterDetails(id)


}