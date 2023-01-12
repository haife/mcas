package com.haife.mcas.mvp.contract

import androidx.fragment.app.Fragment
import com.haife.mcas.mvp.IModel
import com.haife.mcas.mvp.IView

interface MainContract {
    interface View : IView {

        fun getFragment(): Fragment

    }

    interface Model : IModel
}