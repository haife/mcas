package com.haife.mcas.di.module

import com.haife.mcas.di.scope.ActivityScope
import com.haife.mcas.mvp.contract.MainContract
import com.haife.mcas.mvp.model.MainModel
import dagger.Module
import dagger.Provides

@Module
//构建MainModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MainModule(private val view: MainContract.View) {
    @ActivityScope
    @Provides
    fun provideMainView(): MainContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideMainModel(model: MainModel): MainContract.Model {
        return model
    }
}