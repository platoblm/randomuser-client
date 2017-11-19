package com.example.randomuser.models

/**
 * An error than can be presented to the user
*/
data class DisplayError(val errMessage : String, private val error : Throwable) : Throwable(error)