package com.example.randomuser.base.rx

import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class SchedulersTransformer @Inject constructor() {

    private val computation = Schedulers.computation()
    private val main = AndroidSchedulers.mainThread()

    fun <T> forSingle() = SingleTransformer<T, T> {
        it.subscribeOn(computation)
                .observeOn(main)
    }
}