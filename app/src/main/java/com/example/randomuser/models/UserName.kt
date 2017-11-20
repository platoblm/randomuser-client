package com.example.randomuser.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserName(val first: String,
                    val last: String) :Parcelable