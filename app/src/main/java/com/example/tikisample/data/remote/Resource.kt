package com.example.tikisample.data.remote

/**
 * Created by Quang Nguyen on 7/31/20.
 */

/**
 * A generic class that holds a value with its loading status.
 * @param T
 */
data class Resource<out T>(
    val status: Status,
    val data: T?,
    val exception: BaseException?
) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(exception: BaseException?, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, exception)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}