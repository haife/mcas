package com.haife.mcas.di.component

import com.haife.mcas.MainActivity
import com.haife.mcas.di.module.MainModule
import com.haife.mcas.mvp.ui.fragment.MainFragment
import dagger.Component


@Component(modules = [MainModule::class], dependencies = [AppComponent::class])
interface MainComponent {
    fun inject(fragment: MainActivity)
    fun inject(fragment: MainFragment)

}