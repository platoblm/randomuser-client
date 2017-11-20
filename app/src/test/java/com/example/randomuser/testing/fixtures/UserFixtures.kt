package com.example.randomuser.testing.fixtures

import com.example.randomuser.models.Image
import com.example.randomuser.models.Location
import com.example.randomuser.models.User
import com.example.randomuser.models.UserName

object UserFixtures {

    fun createUser() = User(email = "ivanice.rezende@example.com",
            name = UserName(
                    first = "ivanice",
                    last = "rezende"),
            location = Location(
                    street = "4012 rua são josé",
                    city = "bragança paulista",
                    state = "bahia",
                    postcode = "99541"),
            image = Image(
                    smallUrl = "https://randomuser.me/api/portraits/thumb/women/84.jpg",
                    largeUrl = "https://randomuser.me/api/portraits/women/84.jpg")
    )

    fun createOtherUser() = User(email = "ceyhun.erbay@example.com",
            name = UserName(
                    first = "ceyhun",
                    last = "erbay"),
            location = Location(
                    street = "4223 abanoz sk",
                    city = "erzincan",
                    state = "sakarya",
                    postcode = "34045"),
            image = Image(
                    smallUrl = "https://randomuser.me/api/portraits/thumb/men/46.jpg",
                    largeUrl = "https://randomuser.me/api/portraits/men/46.jpg")
    )

    fun usersForSuccessfulApiResponse() = listOf(createUser(), createOtherUser())
}