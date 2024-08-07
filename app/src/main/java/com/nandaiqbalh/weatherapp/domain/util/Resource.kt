package com.nandaiqbalh.weatherapp.domain.util

sealed class Resource<T>(
    val payload: T? = null,
    val message: String? = null,
    val exception: Exception? = null
) {
    class Success<T>(val data: T) : Resource<T>(data)
    class Empty<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) :
        Resource<T>(data, message = message)

    class Loading<T>(data: T? = null) : Resource<T>(data)
}