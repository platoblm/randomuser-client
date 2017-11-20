package com.example.randomuser.ui.users

import android.os.Bundle
import com.example.randomuser.R
import com.example.randomuser.base.BaseActivity
import com.example.randomuser.models.User
import com.example.randomuser.ui.users.details.UserDetailsActivity
import com.example.randomuser.ui.users.details.UserDetailsFragment
import com.example.randomuser.ui.users.list.UserListFragment


class UsersActivity : BaseActivity(), UserListFragment.Host {

    private var detailsFragment : UserDetailsFragment? = null

    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)
        setTitle(R.string.title_list)
        setContentView(R.layout.activity_users)

        if (resources.getBoolean(R.bool.is_landscape)) {
            setupDetailsFragment()
        }
    }

    override fun onUserSelected(user: User) {
        if (detailsFragment != null) {
            detailsFragment?.showUser(user)
            return
        }
        startActivity(UserDetailsActivity.intent(this, user))
    }

    private fun setupDetailsFragment() {
        detailsFragment = supportFragmentManager
                .findFragmentById(R.id.details_container) as? UserDetailsFragment

        if (detailsFragment == null) {
            detailsFragment = UserDetailsFragment()
            supportFragmentManager.beginTransaction()
                    .add(R.id.details_container,  detailsFragment)
                    .commit()
        }
    }
}