package com.example.randomuser.ui.users.list

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.support.annotation.StringRes
import com.example.randomuser.R
import com.example.randomuser.base.helpers.ResourcesHelper
import com.example.randomuser.models.DisplayError
import com.example.randomuser.models.User
import com.example.randomuser.services.users.UserService
import com.example.randomuser.testing.TestSchedulers
import com.example.randomuser.testing.fixtures.UserFixtures
import com.example.randomuser.testing.livedata.TestObserver
import com.example.randomuser.testing.whenever
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnit

class UserListPresenterTest {

    @Rule @JvmField val liveData = InstantTaskExecutorRule()
    @Rule @JvmField val mockito = MockitoJUnit.rule()

    @Mock lateinit var resources: ResourcesHelper
    @Mock lateinit var service: UserService

    val viewStateObserver = TestObserver<UserListViewState>()
    val showUserObserver = TestObserver<User>()

    val bob = UserFixtures.createUser()
    val alice = UserFixtures.createOtherUser()

    val apiResponse = PublishSubject.create<List<User>>()

    lateinit var presenter: UserListPresenter

    @Before fun setup() {
        makeServiceReturn(apiResponse.take(1).singleOrError())

        presenter = UserListPresenter(service, resources, TestSchedulers())

        presenter.viewState().observeForever(viewStateObserver)
        presenter.showUser().observeForever(showUserObserver)
    }

    @Test fun shouldShowLoadingAndRequestUsersInitially() {
        verify(service).listUsers()
        assertThat(viewStateObserver.last()).isEqualTo(
                UserListViewState(showLoading = true, showError = false, showItems = false))
    }

    @Test fun shouldShowItemsOnSuccess() {
        val expectedItems = expectedListItemsForSuccess()

        apiResponse.onNext(listOf(bob, alice))

        viewStateObserver.last()!!.apply {
            assertThat(showItems).isTrue()
            assertThat(showLoading).isFalse()
            assertThat(showError).isFalse()
            assertThat(items).hasSameSizeAs(expectedItems)
            assertItemsAreEqualExceptHandler(items[0], expectedItems[0])
            assertItemsAreEqualExceptHandler(items[1], expectedItems[1])
        }
    }

    @Test fun shouldShowUserWhenItemSelected() {
        val indexOfAlice = 1
        apiResponse.onNext(listOf(bob, alice))
        val items = viewStateObserver.last()!!.items

        items[indexOfAlice].simulateSelecting()

        assertThat(showUserObserver.last()).isSameAs(alice)
    }

    @Test fun shouldShowErrorWhenServiceFails() {
        apiResponse.onError(DisplayError("expected", Throwable()))

        assertThat(viewStateObserver.last()).isEqualTo(
                UserListViewState(showError = true, errorMessage = "expected"))
    }

    @Test fun shouldHandleUnknownError() {
        mockString(R.string.unknown_error_user_message, "unknown error")

        apiResponse.onError(RuntimeException())

        assertThat(viewStateObserver.last()).isEqualTo(
                UserListViewState(showError = true, errorMessage = "unknown error"))
    }

    private fun makeServiceReturn(response: Single<List<User>>) {
        whenever(service.listUsers()).thenReturn(response)
    }

    private fun mockString(@StringRes res: Int, text: String) =
            whenever(resources.string(res)).thenReturn(text)

    private fun expectedListItemsForSuccess(): List<UserListItem> {
        val itemFrom: (User) -> UserListItem = {
            UserListItem(it.image.smallUrl, "${it.name.first} ${it.name.last}", {})
        }
        return listOf(itemFrom(bob), itemFrom(alice))
    }

    private fun assertItemsAreEqualExceptHandler(a: UserListItem, b: UserListItem) {
        assertThat(a.imageUrl).isEqualTo(b.imageUrl)
        assertThat(a.title).isEqualTo(b.title)
    }

    private fun UserListItem.simulateSelecting() {
        whenSelected.invoke()
    }
}