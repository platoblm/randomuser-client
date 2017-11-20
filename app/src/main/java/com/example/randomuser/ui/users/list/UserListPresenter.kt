package com.example.randomuser.ui.users.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.randomuser.base.helpers.ResourcesHelper
import com.example.randomuser.base.livedata.SingleEventWithValue
import com.example.randomuser.base.mvp.Presenter
import com.example.randomuser.base.rx.SchedulersTransformer
import com.example.randomuser.models.User
import com.example.randomuser.services.users.UserService
import javax.inject.Inject

class UserListPresenter @Inject constructor(private val service: UserService,
                                            resources: ResourcesHelper,
                                            schedulers: SchedulersTransformer) : Presenter(schedulers) {

    private val viewState = MutableLiveData<UserListViewState>()
    private val showUser = SingleEventWithValue<User>()
    private val converter = UserListConverter(resources)

    init {
        requestUsers()
    }

    fun viewState(): LiveData<UserListViewState> = viewState

    fun showUser(): LiveData<User> = showUser

    fun onTryAgainSelected() = requestUsers()

    private fun requestUsers() {
        viewState.value = UserListViewState(showLoading = true)

        service.listUsers()
                .map{ converter.convertSuccess(it, showUser::call) }
                .onErrorReturn(converter::convertError)
                .manage()
                .subscribe(viewState::setValue)
    }
}