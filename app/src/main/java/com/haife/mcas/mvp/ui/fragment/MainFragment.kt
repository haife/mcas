package com.haife.mcas.mvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.haife.mcas.R
import com.haife.mcas.base.BaseSupportFragment
import com.haife.mcas.di.component.AppComponent
import com.haife.mcas.di.module.MainModule
import com.haife.mcas.mvp.contract.MainContract
import com.haife.mcas.mvp.presenter.MainPresenter


class MainFragment : BaseSupportFragment<MainPresenter>(), MainContract.View {
    companion object {
        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            return fragment
        }
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    /**
     * 在 onActivityCreate()时调用
     */
    override fun initData(savedInstanceState: Bundle?) {
        initListener()
    }

    private fun initListener() {

    }

    override fun getFragment(): Fragment = this
    override fun showMessage(message: String) {

    }
}