package com.example.randomuser.ui.users.list


data class UserListViewState(val showLoading : Boolean,
                             val showErrorState : Boolean,
                             val showList : Boolean,
                             val errorMessage : String?,
                             val items : List<String>)