package com.example.randomuser.ui.users.details

import com.example.randomuser.base.mvp.Presenter
import com.example.randomuser.base.rx.SchedulersTransformer
import javax.inject.Inject


class UserDetailsPresenter @Inject constructor(schedulers: SchedulersTransformer): Presenter(schedulers) {
}