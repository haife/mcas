package com.haife.mcas

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import com.haife.mcas.base.BaseSupportActivity
import com.haife.mcas.di.component.AppComponent
import com.haife.mcas.mvp.presenter.MainPresenter

class MainActivity() : BaseSupportActivity<MainPresenter>() {


    override fun setupActivityComponent(appComponent: AppComponent) {

    }

    override fun initView(savedInstanceState: Bundle?): Int  = R.layout.activity_main

    override fun initData(savedInstanceState: Bundle?) {

    }

}