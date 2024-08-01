package com.example.imran_mamirov_6_2.data.network.model


import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Character>
)