package com.example.imran_mamirov_6_2.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.imran_mamirov_6_2.data.api.CartoonApiService
import com.example.imran_mamirov_6_2.data.model.BaseResponse
import com.example.imran_mamirov_6_2.data.model.Character
import com.example.imran_mamirov_6_2.utils.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: CartoonApiService) {

    fun getAllCharacters(): LiveData<Resource<List<Character>>> {
        val data = MutableLiveData<Resource<List<Character>>>()
        data.postValue(Resource.Loading())
        api.getAllCharacters().enqueue(object : Callback<BaseResponse<Character>> {
            override fun onResponse(
                p0: Call<BaseResponse<Character>>,
                p1: Response<BaseResponse<Character>>
            ) {
                data.postValue(Resource.Success(p1.body()!!.results))
            }

            override fun onFailure(p0: Call<BaseResponse<Character>>, p1: Throwable) {
                data.postValue(Resource.Error(p1.message!!))
            }
        })
        return data
    }

    fun getCharacterDetails(id: Int): LiveData<Resource<Character>> {
        val data = MutableLiveData<Resource<Character>>()
        data.postValue(Resource.Loading())
        api.getCharacterDetails(id).enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                Log.e("ololo", "onResponse: ${response.body()}", )
                response.body().let {
                    data.postValue(Resource.Success(response.body()!!))
                }
            }

            override fun onFailure(p0: Call<Character>, p1: Throwable) {
                Log.e("ololo", "onFailure: $p1", )
            }
        })
        return data
    }
}