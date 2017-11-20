package com.example.randomuser.base.images

import android.app.Application
import android.widget.ImageView
import com.squareup.picasso.Picasso
import javax.inject.Inject

class ImageLoaderWithPicasso @Inject constructor(app : Application) : ImageLoader {

    private val picasso = Picasso.with(app)

    override fun loadInto(imageUrl: String?, imageView: ImageView) {
        picasso.load(imageUrl)
                .into(imageView)
    }
}