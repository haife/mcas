package com.haife.mcas.mvp.presenter

import android.app.Application
import com.haife.mcas.di.scope.ActivityScope
import com.haife.mcas.di.scope.FragmentScope
import com.haife.mcas.http.imageloader.ImageLoader
import com.haife.mcas.integration.AppManager
import com.haife.mcas.mvp.BasePresenter
import com.haife.mcas.mvp.contract.MainContract

import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject


@ActivityScope
class MainPresenter
@Inject
constructor(model: MainContract.Model, rootView: MainContract.View) :
    BasePresenter<MainContract.Model, MainContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler

    @Inject
    lateinit var mApplication: Application

    @Inject
    lateinit var mImageLoader: ImageLoader

    @Inject
    lateinit var mAppManager: AppManager

}