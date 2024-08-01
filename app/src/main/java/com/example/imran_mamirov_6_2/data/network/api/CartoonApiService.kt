package com.example.imran_mamirov_6_2.data.network.api

import com.example.imran_mamirov_6_2.data.network.model.BaseResponse
import com.example.imran_mamirov_6_2.data.network.model.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CartoonApiService {

    @GET("character")
    suspend fun getAllCharacters(): BaseResponse<Character>

    @GET("character/{id}")
    suspend fun getCharacterDetails(@Path("id") id: Int): Character
}