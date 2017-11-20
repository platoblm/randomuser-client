package com.example.randomuser.testing.livedata

import android.arch.lifecycle.Observer


class TestObserver<T> : Observer<T> {
    private var last : T? = null

    fun last() : T? = last

    override fun onChanged(value: T?) {
        last = value
    }
}