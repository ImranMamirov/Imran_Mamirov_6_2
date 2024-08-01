package com.example.imran_mamirov_6_2.data.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.imran_mamirov_6_2.data.network.model.Character
import com.example.imran_mamirov_6_2.utils.Resource
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException
import java.io.IOException

abstract class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T): LiveData<Resource<T>> = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            val response = request()
            if (response != null) {
                emit(Resource.Success(response))
            }
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
        }
    }

//    fun getCharacterDetails(id: Int): LiveData<Resource<Character>> = liveData(Dispatchers.IO) {
//        emit(Resource.Loading())
//        try {
//            val response = api.getCharacterDetails(id)
//            if (response.isSuccessful && response.body() != null) {
//                emit(Resource.Success(response.body()!!))
//            } else {
//                emit(Resource.Error(response.message() ?: "Unknown error"))
//            }
//        } catch (e: IOException) {
//            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
//        } catch (e: HttpException) {
//            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
//        } catch (e: Exception) {
//            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
//        }
//    }

}