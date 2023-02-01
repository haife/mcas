package com.haife.mcas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.haife.mcas.base.BaseSupportFragment
import com.haife.mcas.di.component.AppComponent
import com.haife.mcas.mvp.contract.MainContract
import com.haife.mcas.mvp.presenter.MainPresenter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : BaseSupportFragment<MainPresenter>(), MainContract.View {


    companion object {
        fun newInstance(): BlankFragment {
            return BlankFragment()
        }
    }

    override fun getFragment(): Fragment {
        return this
    }

    override fun showMessage(message: String) {

    }

    override fun setupFragmentComponent(appComponent: AppComponent) {

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

}