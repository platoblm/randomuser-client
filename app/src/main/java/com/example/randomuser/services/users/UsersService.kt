package com.example.randomuser.services.users

import io.reactivex.Single
import java.util.*


class UsersService {

    fun getUsers() : Single<List<String>> = Single.just(Collections.emptyList())
}