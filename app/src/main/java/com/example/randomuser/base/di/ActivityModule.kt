package com.example.randomuser.base.di

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule constructor(private val activity: AppCompatActivity){

    @Provides fun activity() = activity
}
