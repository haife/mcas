package com.haife.mcas.mvp.model

import android.app.Application
import com.google.gson.Gson
import com.haife.mcas.di.scope.ActivityScope
import com.haife.mcas.integration.IRepositoryManager
import com.haife.mcas.mvp.BaseModel
import com.haife.mcas.mvp.contract.MainContract
import javax.inject.Inject

@ActivityScope
class MainModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), MainContract.Model {
    @Inject
    lateinit var mGson: Gson

    @Inject
    lateinit var mApplication: Application

    override fun onDestroy() {
        super.onDestroy()
    }
}