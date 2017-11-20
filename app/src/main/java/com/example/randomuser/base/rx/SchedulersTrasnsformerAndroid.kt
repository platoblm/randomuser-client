package com.example.randomuser.base.rx

import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class SchedulersTrasnsformerAndroid @Inject constructor() : SchedulersTransformer {

    private val computation = Schedulers.computation()
    private val main = AndroidSchedulers.mainThread()

    override fun <T> forSingle() = SingleTransformer<T, T> {
        it.subscribeOn(computation)
                .observeOn(main)
    }
}