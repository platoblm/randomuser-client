package com.example.randomuser.base.livedata

/**
 *  We use this to substitute a void method call on the view by the presenter.
 *  Also see SingleEventWithValue.
 */
class SingleEvent : SingleEventWithValue<Any>() {

    fun call() {
        call(Void::class)
    }
}