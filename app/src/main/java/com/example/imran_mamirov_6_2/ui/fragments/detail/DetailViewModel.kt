package com.example.imran_mamirov_6_2.ui.fragments.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.imran_mamirov_6_2.data.network.model.Character
import com.example.imran_mamirov_6_2.data.repository.Repository
import com.example.imran_mamirov_6_2.utils.Resource

class DetailViewModel (private val repository: Repository) : ViewModel() {

    fun getById(id: Int): LiveData<Resource<Character>> = liveData {
        emit(Resource.Loading())
        try {
            val response = repository.getCharacterDetails(id)
            emitSource(response)
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error occurred"))
        }
    }
}