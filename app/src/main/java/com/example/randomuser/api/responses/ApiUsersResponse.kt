package com.example.randomuser.api.responses

import com.example.randomuser.models.Image
import com.example.randomuser.models.Location
import com.example.randomuser.models.User
import com.example.randomuser.models.UserName

class ApiUsersResponse {

    private lateinit var results: List<ApiUser>

    fun toModel(): List<User> = results.map(ApiUser::toModel)

    class ApiUser {

        private lateinit var email: String
        private lateinit var name: ApiUserName
        private lateinit var location: ApiUserLocation
        private lateinit var picture: ApiUserImage

        fun toModel() = User(
                email = email,
                name = name.toModel(),
                location = location.toModel(),
                image = picture.toModel()
        )
    }

    private class ApiUserLocation {
        lateinit var state: String
        lateinit var city: String
        lateinit var street: String
        lateinit var postcode: String

        fun toModel() = Location(city = city, street = street, state = state, postcode = postcode)
    }

    private class ApiUserName {

        lateinit var first: String
        lateinit var last: String

        fun toModel() = UserName(first = first, last = last)
    }

    private class ApiUserImage {

        lateinit var large: String
        lateinit var thumbnail: String

        fun toModel() = Image(thumbnail, large)
    }
}
