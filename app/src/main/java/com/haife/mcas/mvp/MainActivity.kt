package com.haife.mcas.mvp

import android.os.Bundle
import com.haife.mcas.R
import com.haife.mcas.base.BaseSwipeBackActivity
import com.haife.mcas.di.component.AppComponent
import com.haife.mcas.mvp.presenter.MainPresenter
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import kotlinx.android.synthetic.main.activity_main.*
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator
import me.yokeyword.fragmentation.anim.FragmentAnimator

class MainActivity : BaseSwipeBackActivity<MainPresenter>() {


    override fun setupActivityComponent(appComponent: AppComponent) {

    }

    override fun initView(savedInstanceState: Bundle?): Int {
        QMUIStatusBarHelper.translucent(this)
        QMUIStatusBarHelper.setStatusBarLightMode(this)
        return R.layout.activity_main
    }

    override fun initData(savedInstanceState: Bundle?) {
        loadRootFragment(R.id.fl_main,MainFragment.newInstance())
    }

    override fun onCreateFragmentAnimator(): FragmentAnimator {
        return DefaultHorizontalAnimator()
    }
}