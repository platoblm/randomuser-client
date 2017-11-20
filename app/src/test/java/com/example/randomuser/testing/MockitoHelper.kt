package com.example.randomuser.testing

import org.mockito.Mockito

fun <T> whenever(instance : T) = Mockito.`when`(instance)