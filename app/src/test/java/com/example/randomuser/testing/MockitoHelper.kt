package com.example.randomuser.testing

import io.reactivex.functions.Predicate
import org.mockito.Mockito


fun <T> whenever(instance : T) = Mockito.`when`(instance)

fun <T> isEqualTo(other : T) : Predicate<T> = Predicate { other!!.equals(it) }