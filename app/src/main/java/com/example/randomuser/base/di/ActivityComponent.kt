package com.example.randomuser.base.di

import com.example.randomuser.ui.users.UsersActivity
import com.example.randomuser.ui.users.details.UserDetailsFragment
import com.example.randomuser.ui.users.list.UserListFragment
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(activity: UsersActivity)

    fun inject(fragment: UserListFragment)
    fun inject(fragment: UserDetailsFragment)
}

