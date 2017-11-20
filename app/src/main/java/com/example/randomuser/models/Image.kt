package com.example.randomuser.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(val smallUrl: String,
                 val largeUrl: String) : Parcelable