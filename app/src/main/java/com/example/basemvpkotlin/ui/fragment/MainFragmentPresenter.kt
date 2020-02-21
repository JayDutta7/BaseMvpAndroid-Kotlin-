package com.example.basemvpkotlin.ui.fragment

import com.example.basemvpkotlin.ui.base.BasePresenter

class MainFragmentPresenter<V : MainFragmentMVP.IView> : BasePresenter<V>(),
    MainFragmentMVP.IPresenter<V> {

    init {

    }


    override fun onDestroy() {
        onDetach()
    }
}