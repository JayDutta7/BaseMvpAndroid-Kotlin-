package com.example.basemvpkotlin.fragment

import com.example.basemvpkotlin.base.BasePresenter

class MainFragmentPresenter<V : MainFragmentMVP.IView> : BasePresenter<V>(),
    MainFragmentMVP.IPresenter<V> {

    init {

    }


    override fun onDestroy() {
        onDetach()
    }
}