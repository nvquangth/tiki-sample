package com.example.tikisample.ext

import android.content.Context
import com.example.tikisample.R
import com.example.tikisample.data.remote.BaseException
import com.example.tikisample.data.remote.ErrorType
import com.example.tikisample.data.remote.HttpCodeClientServer
import java.net.HttpURLConnection
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by Quang Nguyen on 7/31/20.
 */

fun Context.getErrorMessage(exception: BaseException?): String? {

    if (exception == null) return null

    when (exception.errorType) {
        ErrorType.NETWORK -> {
            return when (exception.cause) {
                is UnknownHostException -> this.resources.getString(R.string.no_internet_connection)
                is SocketTimeoutException -> this.resources.getString(R.string.connect_timeout)
                else -> this.resources.getString(R.string.unknown_error)
            }
        }
        ErrorType.HTTP -> {
            // get message base on http code to map with specification
            // the server and client can define several codes such as
            // 800: notify to app need force update new version
            // 900: notify to app that server maintain
            // ...
            return when (exception.httpCode) {
                // 401
                HttpURLConnection.HTTP_UNAUTHORIZED -> exception.cause?.message
                // 500
                HttpURLConnection.HTTP_INTERNAL_ERROR -> exception.cause?.message
                // 800: force update app
                HttpCodeClientServer.FORCE_UPDATE.code -> this.resources.getString(R.string.force_update_app)
                // 900: server maintain
                HttpCodeClientServer.SERVER_MAINTAIN.code -> this.resources.getString(R.string.server_maintain_message)

                else -> this.resources.getString(R.string.unknown_error)
            }
        }
        ErrorType.SERVER -> {

        }
        else -> return this.resources.getString(R.string.unknown_error)
    }
    return null
}
