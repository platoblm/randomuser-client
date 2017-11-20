package com.example.randomuser.base.helpers

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun View.show(visible : Boolean) {
    if (visible) {
        visibility = View.VISIBLE
    }else {
        visibility = View.GONE
    }
}

fun View.onClick(listener : () -> Unit) = this.setOnClickListener { listener() }

fun ViewGroup.inflateWithoutAttaching(@LayoutRes layout : Int) : View =
        LayoutInflater.from(context).inflate(layout, this, false)