package com.example.randomuser.ui.users.list

import com.example.randomuser.models.User

data class UserListPresenterState(val responsePending : Boolean,
                                  val items : List<User>,
                                  val responseError : Throwable)