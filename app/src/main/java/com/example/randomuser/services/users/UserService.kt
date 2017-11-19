package com.example.randomuser.services.users

import com.example.randomuser.api.ApiErrorConverter
import com.example.randomuser.api.ApiProvider
import com.example.randomuser.api.responses.ApiUsersResponse
import com.example.randomuser.models.User
import io.reactivex.Single
import javax.inject.Inject

class UserService @Inject constructor(private val api : ApiProvider,
                                      private val errorConverter : ApiErrorConverter){

    fun listUsers() : Single<List<User>> = api.randomUserApi()
            .listUsers()
            .onErrorResumeNext { errorConverter.convert(it) }
            .map(ApiUsersResponse::toModel)
}