package com.example.randomuser.ui.users.list

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import com.example.randomuser.R
import com.example.randomuser.base.BaseFragment
import com.example.randomuser.base.di.ActivityComponent
import com.example.randomuser.base.helpers.show
import kotlinx.android.synthetic.main.fragment_users_list.*
import javax.inject.Inject

class UserListFragment : BaseFragment<UserListPresenter>() {

    @Inject lateinit var adapter : UserListAdapter

    override fun layout() = R.layout.fragment_users_list

    override fun inject(component: ActivityComponent) = component.inject(this)

    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)

        presenter.viewState().observe(this, Observer { update(it!!) })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.adapter = adapter
    }

    private fun update(state : UserListViewState) {
        progress_indicator.show(state.showLoading)
        error_state.show(state.showErrorState)
        error_message.text = state.errorMessage
        list.show(state.showList)
        adapter.setItems(state.items)
    }
}