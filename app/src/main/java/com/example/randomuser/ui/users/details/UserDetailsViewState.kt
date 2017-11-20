package com.example.randomuser.ui.users.details


data class UserDetailsViewState(val showEmptyState : Boolean = false,
                                val showDetails : Boolean = false,
                                val imageUrl : String? = null,
                                val name : String? = null,
                                val email : String? = null,
                                val location : String? = null)