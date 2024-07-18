package com.example.imran_mamirov_6_2.utils

sealed class Resource<T> {
    class Loading<T>: Resource<T>()
    class Success<T>(val data: T): Resource<T>()
    class Error<T>(val message: String): Resource<T>()
}