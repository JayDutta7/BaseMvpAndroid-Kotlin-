package com.example.basemvpkotlin.activity

import com.example.basemvpkotlin.base.BasePresenter

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