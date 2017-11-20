package com.example.randomuser.testing

import com.google.gson.Gson
import java.io.InputStreamReader


object TestingResources {

    private val gson = Gson()

    fun <T> parseJsonResourceAs(jsonFilePath: String, tClass: Class<T>): T {
        val classLoader = TestingResources::class.java.classLoader
        val inputStream = classLoader.getResourceAsStream(jsonFilePath)
        return gson.fromJson(InputStreamReader(inputStream), tClass)
    }

}