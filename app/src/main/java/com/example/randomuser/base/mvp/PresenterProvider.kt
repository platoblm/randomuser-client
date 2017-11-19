package com.example.randomuser.base.mvp

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import javax.inject.Provider

class PresenterProvider {

    fun <T> getPresenter(provider  : Provider<T>, activity : FragmentActivity) : T =
            getPresenter(provider, { ViewModelProviders.of(activity, it)})

    fun <T> getPresenter(provider  : Provider<T>, fragment : Fragment) : T =
            getPresenter(provider, { ViewModelProviders.of(fragment, it)})

    @Suppress("UNCHECKED_CAST")
    private fun <T> getPresenter(provider  : Provider<T>,
                                 viewModelProviderGetter: (ViewModelProvider.Factory) -> ViewModelProvider) : T {

        val providerAsFactory = object : ViewModelProvider.Factory {
            override fun <P : ViewModel> create(ignore: Class<P>) = provider.get() as P
        }

        return viewModelProviderGetter
                .invoke(providerAsFactory)
                .get(ViewModel::class.java) as T
    }
}