package com.example.basemvpkotlin.ui.activity

import com.example.basemvpkotlin.ui.base.BasePresenter

class MainActivityPresenter<V : MainActivityMVP.IView> : BasePresenter<V>(),
    MainActivityMVP.IPresenter<V> {

    /*Repository Acesss for presenter*/
    private var mainActivityRepository: MainActivityRepository? = null

    init {
        /*initialize presenter*/
        mainActivityRepository = MainActivityRepository()
    }



    override fun onDestroy() {
        onDetach()
    }
}