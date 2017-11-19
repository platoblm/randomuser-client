package com.example.randomuser.api

import com.example.randomuser.R
import com.example.randomuser.base.helpers.ResourcesHelper
import com.example.randomuser.models.DisplayError
import io.reactivex.Single
import java.io.IOException
import javax.inject.Inject


class ApiErrorConverter @Inject constructor(private val resources : ResourcesHelper) {

    fun <T> convert(throwable: Throwable) : Single<T> {
        val message = messageFrom(throwable)
        return Single.error(DisplayError(message, throwable))
    }

    //TODO if the error is an HttpException check to see if there's a server error response. see https://randomuser.me/documentation#errors
    private fun messageFrom(throwable: Throwable) : String {
        return when(throwable) {
            is IOException -> resources.string(R.string.network_error_user_message)
            else -> resources.string(R.string.unknown_error_user_message)
        }
    }
}