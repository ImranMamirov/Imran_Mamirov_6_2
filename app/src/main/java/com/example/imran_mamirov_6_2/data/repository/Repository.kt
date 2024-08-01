package com.example.imran_mamirov_6_2.data.repository

import androidx.lifecycle.LiveData
import com.example.imran_mamirov_6_2.data.base.BaseRepository
import com.example.imran_mamirov_6_2.data.network.api.CartoonApiService
import com.example.imran_mamirov_6_2.data.network.model.Character
import com.example.imran_mamirov_6_2.utils.Resource

class Repository(private val api: CartoonApiService) : BaseRepository() {

    fun getAllCharacters(): LiveData<Resource<List<Character>>> = doRequest {
        api.getAllCharacters().results
    }

    fun getCharacterDetails(id: Int): LiveData<Resource<Character>> = doRequest {
        api.getCharacterDetails(id)
    }
}