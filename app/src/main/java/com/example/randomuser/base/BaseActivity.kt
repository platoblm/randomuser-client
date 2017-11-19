package com.example.randomuser.base

import android.support.v7.app.AppCompatActivity
import com.example.randomuser.base.di.ActivityComponent
import com.example.randomuser.base.di.ActivityComponentProvider
import com.example.randomuser.base.di.ActivityModule
import com.example.randomuser.base.di.AppComponentProvider


abstract class BaseActivity : AppCompatActivity(), ActivityComponentProvider {

    private val activityComponent: ActivityComponent by lazy {
        (application as AppComponentProvider)
                .appComponent()
                .plus(ActivityModule(this))
    }

    override fun activityComponent() = activityComponent

}