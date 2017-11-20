package com.example.randomuser.models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class User(val name : UserName,
                val email : String,
                val location : Location,
                val image : Image) : Parcelable
