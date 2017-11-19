package com.example.randomuser.base.helpers

import android.view.View


fun View.show(visible : Boolean) {
    if (visible) {
        visibility = View.VISIBLE
    }else {
        visibility = View.GONE
    }
}