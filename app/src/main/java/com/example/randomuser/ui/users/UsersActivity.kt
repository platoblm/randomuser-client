package com.example.randomuser.ui.users

import android.os.Bundle
import android.view.View
import com.example.randomuser.R
import com.example.randomuser.base.BaseActivity
import com.example.randomuser.ui.users.details.UserDetailsFragment


class UsersActivity : BaseActivity() {

    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)
        setContentView(R.layout.activity_users)

        if (findViewById<View>(R.id.details_container) != null) {
            if (supportFragmentManager.findFragmentById(R.id.details_container) == null) {
                supportFragmentManager.beginTransaction()
                        .add(R.id.details_container,  UserDetailsFragment())
                        .commit()
            }
        }
    }
}