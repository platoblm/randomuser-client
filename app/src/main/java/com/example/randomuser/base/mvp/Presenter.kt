package com.example.randomuser.base.mvp

import android.arch.lifecycle.ViewModel
import com.example.randomuser.base.rx.SchedulersTransformer
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable


open class Presenter constructor(private val schedulers : SchedulersTransformer) : ViewModel() {

    private val toUnsubscribeOnDestroy = CompositeDisposable()

    override fun onCleared() {
        toUnsubscribeOnDestroy.clear()
    }

    protected fun <T> Single<T>.manage(): Single<T> {
        return compose(schedulers.forSingle<T>())
                .doOnSubscribe { toUnsubscribeOnDestroy.add(it) }
    }
}