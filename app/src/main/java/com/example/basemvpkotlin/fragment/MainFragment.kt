package com.example.basemvpkotlin.fragment

import android.os.Bundle
import android.view.View
import com.example.basemvpkotlin.R
import com.example.basemvpkotlin.base.BaseFragment

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
