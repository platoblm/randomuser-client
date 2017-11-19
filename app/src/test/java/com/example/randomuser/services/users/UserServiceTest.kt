package com.example.randomuser.services.users

import com.example.randomuser.api.Api
import com.example.randomuser.api.ApiErrorConverter
import com.example.randomuser.api.ApiProvider
import com.example.randomuser.api.responses.ApiUsersResponse
import com.example.randomuser.models.DisplayError
import com.example.randomuser.testing.ResourcesHelper.parseJsonResourceAs
import com.example.randomuser.testing.fixtures.UserFixtures.usersForSuccessfulApiResponse
import com.example.randomuser.testing.whenever
import io.reactivex.Single
import io.reactivex.Single.error
import io.reactivex.Single.just
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit

class UserServiceTest {

    @Rule @JvmField val mockito = MockitoJUnit.rule()

    @Mock lateinit var errorConverter: ApiErrorConverter
    @Mock lateinit var api: Api
    @Mock lateinit var apiProvider: ApiProvider

    lateinit var service: UserService

    @Before fun setup() {
        whenever(apiProvider.randomUserApi()).thenReturn(api)

        service = UserService(apiProvider, errorConverter)
    }

    @Test fun shouldDeserializeSuccessfulResponse() {
        val expected = usersForSuccessfulApiResponse()
        val response = parseJsonResourceAs("responses/users_success.json", ApiUsersResponse::class.java)
        makeApiReturn(just(response))

        val observer = service.listUsers().test()

        observer.assertValue(expected)
    }

    @Test fun shouldParseErrors() {
        val thrown = Throwable()
        val expected = DisplayError("error", thrown)
        makeApiReturn(error(thrown))
        makeErrorConverterReturn(expected, `for`= thrown)

        val observer = service.listUsers().test()

        observer.assertError(expected)
    }

    private fun makeApiReturn(response: Single<ApiUsersResponse>) =
            whenever(api.listUsers()).thenReturn(response)

    private fun makeErrorConverterReturn(result : Throwable, `for`: Throwable) =
            whenever(errorConverter.convert<String>(`for`)).thenReturn(error(result))
}