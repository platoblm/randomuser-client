package com.example.randomuser.base.di

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class AppModule constructor(val app: Application){

    @Provides fun providesApp(): Application = app
}
