package com.example.randomuser.base.di

import com.example.randomuser.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(app: App)

    fun plus(module: ActivityModule): ActivityComponent
}
