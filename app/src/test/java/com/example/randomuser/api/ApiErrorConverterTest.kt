package com.example.randomuser.api

import android.support.annotation.StringRes
import com.example.randomuser.R
import com.example.randomuser.base.helpers.ResourcesHelper
import com.example.randomuser.models.DisplayError
import com.example.randomuser.testing.whenever
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import java.io.IOException

class ApiErrorConverterTest {

    @Rule @JvmField val mockito = MockitoJUnit.rule()

    @Mock lateinit var resources: ResourcesHelper

    lateinit var converter: ApiErrorConverter

    @Before fun setup() {
        converter = ApiErrorConverter(resources)
    }

    @Test fun shouldConvertNetworkError() {
        mockString(R.string.network_error_user_message, "network")
        val thrown = IOException()

        val result = converter.convert<String>(thrown)
                .test()

        result.assertError(DisplayError("network", thrown))
    }

    @Test fun shouldShowDefaultMessageIfErrorUnknown() {
        mockString(R.string.unknown_error_user_message, "unknown")
        val thrown = RuntimeException()

        val result = converter.convert<String>(thrown)
                .test()

        result.assertError(DisplayError("unknown", thrown))
    }

    private fun mockString(@StringRes res: Int, text: String) =
            whenever(resources.string(res)).thenReturn(text)
}