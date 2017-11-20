package com.example.randomuser.ui.users.list

import com.example.randomuser.R
import com.example.randomuser.base.helpers.ResourcesHelper
import com.example.randomuser.models.DisplayError
import com.example.randomuser.models.User
import javax.inject.Inject

//TODO create string resource for the formatting of first and last names.

class UserListConverter @Inject constructor(private val resources: ResourcesHelper) {

    fun convertSuccess(users: List<User>, onUserSelected: (User) -> Unit): UserListViewState {
        val items = users.map { it.toItemWith(onUserSelected) }

        return UserListViewState(
                showItems = true,
                items = items)
    }

    fun convertError(error: Throwable): UserListViewState {
        val message = (error as? DisplayError)?.errorMessage
                ?: messageForUnknownError()

        return UserListViewState(
                showError = true,
                errorMessage = message)
    }

    private fun User.toItemWith(onUserSelected: (User) -> Unit): UserListItem {
        return UserListItem(
                imageUrl = image.smallUrl,
                title = name.run { "$first $last" },
                whenSelected = { onUserSelected(this) }
        )
    }

    private fun messageForUnknownError() =
            resources.string(R.string.unknown_error_user_message)
}