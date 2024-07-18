package com.example.imran_mamirov_6_2.data.api

import com.example.imran_mamirov_6_2.data.model.BaseResponse
import com.example.imran_mamirov_6_2.data.model.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CartoonApiService {

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): Response<BaseResponse<Character>>

    @GET("character/{id}")
    suspend fun getCharacterDetails(@Path("id") id: Int): Response<BaseResponse<Character>>
}