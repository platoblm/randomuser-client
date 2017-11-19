package com.example.randomuser

import android.app.Application
import com.example.randomuser.base.di.AppModule
import com.example.randomuser.base.di.DaggerAppComponent
import com.example.randomuser.base.di.AppComponentProvider

class App : Application(), AppComponentProvider {

    val appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    override fun appComponent()= appComponent

}