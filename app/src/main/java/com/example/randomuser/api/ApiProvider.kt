package com.example.randomuser.api

import com.example.randomuser.R
import com.example.randomuser.base.helpers.ResourcesHelper
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiProvider @Inject constructor(resources : ResourcesHelper) {

    private val api = Retrofit.Builder()
            .baseUrl(resources.string(R.string.api_host))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)

    fun randomUserApi() : Api = api
}