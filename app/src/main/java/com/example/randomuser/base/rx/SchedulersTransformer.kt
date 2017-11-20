package com.example.randomuser.base.rx

import io.reactivex.SingleTransformer


interface SchedulersTransformer {

    fun <T> forSingle() : SingleTransformer<T, T>
}