package com.example.randomuser.ui.users.details

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import com.example.randomuser.R
import com.example.randomuser.base.BaseFragment
import com.example.randomuser.base.di.ActivityComponent
import com.example.randomuser.base.helpers.show
import com.example.randomuser.base.images.ImageLoader
import com.example.randomuser.models.User
import kotlinx.android.synthetic.main.fragment_user_details.*
import javax.inject.Inject


class UserDetailsFragment : BaseFragment<UserDetailsPresenter>() {

    @Inject lateinit var imageLoader : ImageLoader

    override fun layout() = R.layout.fragment_user_details
    override fun inject(component: ActivityComponent) = component.inject(this)

    fun showUser(user: User) = presenter.showUser(user)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.viewState().observe(this, Observer { it?.applyToView() })
    }

    private fun UserDetailsViewState.applyToView() {
        empty_message_view.show(showEmptyState)
        details_group.show(showDetails)

        imageLoader.loadInto(imageUrl, photo_view)
        name_view.text = name
        email_view.text = email
        location_view.text = location
    }
}