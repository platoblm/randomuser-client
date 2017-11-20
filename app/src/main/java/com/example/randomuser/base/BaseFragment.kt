package com.example.randomuser.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.randomuser.base.di.ActivityComponent
import com.example.randomuser.base.di.ActivityComponentProvider
import com.example.randomuser.base.mvp.Presenter
import com.example.randomuser.base.mvp.PresenterProvider
import javax.inject.Inject
import javax.inject.Provider

abstract class BaseFragment<P : Presenter> : Fragment() {

    @Inject lateinit var presenterProvider: Provider<P>

    protected lateinit var presenter: P

    @LayoutRes
    abstract fun layout(): Int

    abstract fun inject(component: ActivityComponent)

    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)

        inject(getActivityComponent())
        presenter = PresenterProvider().getPresenter(presenterProvider, this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(layout(), container, false)

    private fun getActivityComponent() = (activity as ActivityComponentProvider).activityComponent()
}