package com.example.imran_mamirov_6_2.data.api

import com.example.imran_mamirov_6_2.data.model.BaseResponse
import com.example.imran_mamirov_6_2.data.model.Character
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CartoonApiService {

    @GET("character")
    suspend fun getAllCharacters(): Response<BaseResponse<Character>>

    @GET("character/{id}")
    suspend fun getCharacterDetails(@Path("id") id: Int): Response<Character>
}