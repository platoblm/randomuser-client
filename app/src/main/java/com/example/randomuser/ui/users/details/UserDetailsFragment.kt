package com.example.randomuser.ui.users.details

import com.example.randomuser.R
import com.example.randomuser.base.BaseFragment
import com.example.randomuser.base.di.ActivityComponent


class UserDetailsFragment : BaseFragment<UserDetailsPresenter>() {

    override fun layout() = R.layout.fragment_user_details
    override fun inject(component: ActivityComponent) = component.inject(this)

}