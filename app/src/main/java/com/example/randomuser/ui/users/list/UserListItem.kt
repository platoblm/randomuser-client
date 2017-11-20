package com.example.randomuser.ui.users.list


data class UserListItem(val imageUrl : String,
                        val title : String,
                        val whenSelected : () -> Unit)