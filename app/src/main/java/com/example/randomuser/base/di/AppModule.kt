package com.example.randomuser.base.di

import android.app.Application
import com.example.randomuser.base.images.ImageLoader
import com.example.randomuser.base.images.ImageLoaderWithPicasso
import com.example.randomuser.base.rx.SchedulersTransformer
import com.example.randomuser.base.rx.SchedulersTrasnsformerAndroid
import dagger.Module
import dagger.Provides

@Module
class AppModule constructor(val app: Application){

    @Provides fun provideApp(): Application = app

    @Provides fun provideSchedulers(instance: SchedulersTrasnsformerAndroid) : SchedulersTransformer = instance

    @Provides fun provideImageLoader(instance: ImageLoaderWithPicasso) : ImageLoader = instance
}
