package com.example.randomuser.ui.users.list

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.view.View
import com.example.randomuser.R
import com.example.randomuser.base.BaseFragment
import com.example.randomuser.base.di.ActivityComponent
import com.example.randomuser.base.helpers.onClick
import com.example.randomuser.base.helpers.show
import com.example.randomuser.models.User
import com.example.randomuser.ui.users.list.recyclerview.UserListAdapter
import kotlinx.android.synthetic.main.fragment_users_list.*
import javax.inject.Inject

class UserListFragment : BaseFragment<UserListPresenter>() {

    interface Host {
        fun onUserSelected(user: User)
    }

    @Inject lateinit var adapter: UserListAdapter

    override fun layout() = R.layout.fragment_users_list

    override fun inject(component: ActivityComponent) = component.inject(this)

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        check(host is Host, { "The host must implement the Host interface" })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.adapter = adapter
        error_try_again.onClick(presenter::onTryAgainSelected)

        presenter.viewState().observe(this, Observer { it?.applyToView() })
        presenter.showUser().observe(this, Observer { it?.show() })
    }

    private fun UserListViewState.applyToView() {
        progress_indicator.show(showLoading)
        error_container.show(showError)
        error_message.text = errorMessage
        list.show(showItems)
        adapter.setItems(items)
    }

    private fun User.show() {
        (host as Host).onUserSelected(this)
    }
}