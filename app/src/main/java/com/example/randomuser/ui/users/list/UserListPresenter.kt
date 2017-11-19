package com.example.randomuser.ui.users.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.randomuser.base.mvp.Presenter
import com.example.randomuser.base.rx.SchedulersTransformer
import javax.inject.Inject


class UserListPresenter @Inject constructor(schedulers: SchedulersTransformer) : Presenter(schedulers) {

    private val viewState = MutableLiveData<UserListViewState>()

    fun viewState() : LiveData<UserListViewState> = viewState
}