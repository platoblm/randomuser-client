package com.example.randomuser.testing

import com.example.randomuser.base.rx.SchedulersTransformer
import io.reactivex.SingleTransformer

class TestSchedulers : SchedulersTransformer {

    // don't do anything in tests
    override fun <T> forSingle() = SingleTransformer<T, T> { it }
}