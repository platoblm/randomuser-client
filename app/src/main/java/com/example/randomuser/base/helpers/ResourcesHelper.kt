package com.example.randomuser.base.helpers

import android.app.Application
import android.support.annotation.StringRes
import javax.inject.Inject


class ResourcesHelper @Inject constructor(private val app: Application) {


    fun string(@StringRes resourceId: Int) = app.getString(resourceId)
}