package com.example.randomuser.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(val state: String,
                    val city: String,
                    val street: String,
                    val postcode: String) : Parcelable