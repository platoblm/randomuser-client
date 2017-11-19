package com.example.randomuser.base.livedata

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/**
 * A live data helper class that allows a value to be observed once.
 * We use this to substitute a call of a method, with one parameter, on the view by the presenter.
 */
open class SingleEventWithValue<T> : LiveData<T>() {

    private val pending = AtomicBoolean(false)

    override fun observe(owner: LifecycleOwner, observer: Observer<T>) {
        super.observe(owner, Observer<T> { t ->
            if (pending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        })
    }

    fun call(value: T) {
        pending.set(true)
        super.setValue(value)
    }
}