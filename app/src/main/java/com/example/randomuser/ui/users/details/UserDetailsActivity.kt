package com.example.randomuser.ui.users.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.randomuser.R
import com.example.randomuser.base.BaseActivity
import com.example.randomuser.models.User
import kotlinx.android.synthetic.main.activity_details.*


class UserDetailsActivity : BaseActivity() {

    companion object {
        private val EXTRA_USER = "extra_user"

        fun intent(context: Context, user: User) = Intent(context, UserDetailsActivity::class.java)
                .putExtra(EXTRA_USER, user)

        private fun Intent.user() = getParcelableExtra<User>(EXTRA_USER)
    }

    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)
        setTitle(R.string.title_details)
        setContentView(R.layout.activity_details)

        if (savedState == null) {
            (details_fragment as UserDetailsFragment).showUser(intent.user())
        }
    }
}