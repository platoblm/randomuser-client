package com.example.randomuser.api

import com.example.randomuser.api.responses.ApiUsersResponse
import io.reactivex.Single
import retrofit2.http.GET

//TODO consider requesting only required fields https://randomuser.me/documentation#incexc

interface Api {

    companion object {
        private const val RESULTS_COUNT = 300
        private const val SEED = "yv"
    }

    @GET("api/?results=$RESULTS_COUNT&seed=$SEED")
    fun listUsers(): Single<ApiUsersResponse>
}