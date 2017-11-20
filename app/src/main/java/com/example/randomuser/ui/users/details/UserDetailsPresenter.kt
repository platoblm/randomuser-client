package com.example.randomuser.ui.users.details

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.randomuser.base.mvp.Presenter
import com.example.randomuser.base.rx.SchedulersTransformer
import com.example.randomuser.models.User
import javax.inject.Inject


class UserDetailsPresenter @Inject constructor(schedulers: SchedulersTransformer) : Presenter(schedulers) {

    private val viewState = MutableLiveData<UserDetailsViewState>()

    init {
        viewState.value = UserDetailsViewState(showEmptyState = true)
    }

    fun viewState(): LiveData<UserDetailsViewState> = viewState

    fun showUser(user: User) {
        val nameDescription = user.name.run { "$first $last" }
        val locationDescription = user.location.run { "$state, $city, $street, $postcode" }

        viewState.value = UserDetailsViewState(
                showDetails = true,
                imageUrl = user.image.largeUrl,
                name = nameDescription,
                location = locationDescription,
                email = user.email)
    }
}

