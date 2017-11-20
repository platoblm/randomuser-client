package com.example.randomuser.ui.users.list

data class UserListViewState(val showLoading : Boolean = false,
                             val showError: Boolean = false,
                             val showItems: Boolean = false,
                             val errorMessage : String? = null,
                             val items : List<UserListItem> = emptyList())