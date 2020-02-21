package com.example.basemvpkotlin.activity

class MainActivityRepository : MainActivityMVP.IRepository {

    private var mainActivityPresenter: MainActivityPresenter<MainActivityMVP.IView>? = null

    init {
        mainActivityPresenter = MainActivityPresenter()
    }

    /*Rest call method from presenter*/
}