package com.example.imran_mamirov_6_2.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.imran_mamirov_6_2.data.api.CartoonApiService
import com.example.imran_mamirov_6_2.data.model.Character
import com.example.imran_mamirov_6_2.data.paging.CharacterPagingSource

class Repository (private val api: CartoonApiService) {

    fun getCharacters(page: Int = 1): LiveData<PagingData<Character>> {
        return Pager(
            pagingSourceFactory = {
                CharacterPagingSource(api)
            },
            config = PagingConfig(
                pageSize = 10
            )
        ).liveData
    }
}