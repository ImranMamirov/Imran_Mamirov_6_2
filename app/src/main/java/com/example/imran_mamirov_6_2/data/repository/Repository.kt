package com.example.imran_mamirov_6_2.data.repository

import androidx.lifecycle.liveData
import com.example.imran_mamirov_6_2.data.api.CartoonApiService
import com.example.imran_mamirov_6_2.utils.Resource
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException
import java.io.IOException

class Repository (private val api: CartoonApiService) {

    fun getAllCharacters() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            val response = api.getAllCharacters()
            if (response.isSuccessful && response.body() != null) {
                emit(Resource.Success(response.body()!!.results))
            }
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
        }
    }

    fun getCharacterDetails(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            val response = api.getCharacterDetails(id)
            if (response.isSuccessful && response.body() != null) {
                emit(Resource.Success(response.body()!!))
            } else {
                emit(Resource.Error(response.message() ?: "Unknown error"))
            }
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
        }
    }
}