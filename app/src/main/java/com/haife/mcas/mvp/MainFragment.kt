package com.haife.mcas.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.haife.mcas.R
import com.haife.mcas.base.BaseSwipeBackFragment
import com.haife.mcas.di.component.AppComponent
import com.haife.mcas.mvp.presenter.MainPresenter
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseSwipeBackFragment<MainPresenter>() {
    companion object {
        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            return fragment
        }
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {

    }


    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view:View = layoutInflater.inflate(R.layout.fragment_main, container, false)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            start(MainFragment2.newInstance())
        }
        return attachToSwipeBack(view)
    }

    override fun initData(savedInstanceState: Bundle?) {

    }
}