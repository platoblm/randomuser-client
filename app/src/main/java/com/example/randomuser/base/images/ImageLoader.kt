package com.example.randomuser.base.images

import android.widget.ImageView

interface ImageLoader {

    fun loadInto(imageUrl : String?, imageView : ImageView)
}