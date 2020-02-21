package com.example.basemvpkotlin.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.basemvpkotlin.R
import com.example.basemvpkotlin.ui.base.BaseFragment

class MainFragment : BaseFragment(), MainFragmentMVP.IView {

    private var mainFragmentPresenter: MainFragmentPresenter<MainFragmentMVP.IView>? = null

    override fun getLayoutRes(): Int {
        return R.layout.fragment_main
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainFragmentPresenter = MainFragmentPresenter()
    }


}
