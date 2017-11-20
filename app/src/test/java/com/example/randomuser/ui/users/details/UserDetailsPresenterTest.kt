package com.example.randomuser.ui.users.details

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.randomuser.testing.TestSchedulers
import com.example.randomuser.testing.fixtures.UserFixtures
import com.example.randomuser.testing.livedata.TestObserver
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UserDetailsPresenterTest {

    @Rule @JvmField val liveData = InstantTaskExecutorRule()

    val viewStateObserver = TestObserver<UserDetailsViewState>()
    val bob = UserFixtures.createUser()

    lateinit var presenter: UserDetailsPresenter

    @Before fun setup() {
        presenter = UserDetailsPresenter(TestSchedulers())
        presenter.viewState().observeForever(viewStateObserver)
    }

    @Test fun shouldShowEmptyStateInitially() {
        assertThat(viewStateObserver.last()).isEqualTo(
                UserDetailsViewState(showEmptyState = true, showDetails = false))
    }

    @Test fun shouldShowUserDetails() {
        presenter.showUser(bob)

        assertThat(viewStateObserver.last()).isEqualTo(
                UserDetailsViewState(
                        showEmptyState = false,
                        showDetails = true,
                        imageUrl = bob.image.largeUrl,
                        name = bob.name.run { "$first $last" },
                        email = bob.email,
                        location = bob.location.run { "$state, $city, $street, $postcode" }))
    }
}