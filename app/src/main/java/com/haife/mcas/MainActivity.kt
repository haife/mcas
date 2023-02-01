package com.haife.mcas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haife.mcas.base.BaseSupportActivity
import com.haife.mcas.base.BaseSwipeBackActivity
import com.haife.mcas.di.component.AppComponent
import com.haife.mcas.mvp.IPresenter
import com.haife.mcas.mvp.presenter.MainPresenter
import com.haife.mcas.mvp.ui.fragment.MainFragment

class MainActivity : BaseSwipeBackActivity<MainPresenter>() {


    override fun setupActivityComponent(appComponent: AppComponent) {

    }

    override fun initView(savedInstanceState: Bundle?): Int  = R.layout.activity_main

    override fun initData(savedInstanceState: Bundle?) {
            loadRootFragment(R.id.fl_main,MainFragment.newInstance())
    }
}