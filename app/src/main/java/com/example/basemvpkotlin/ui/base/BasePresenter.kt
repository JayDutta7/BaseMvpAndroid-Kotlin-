package com.example.basemvpkotlin.ui.base

abstract class BasePresenter<V : IBaseView> : IBasePresenter<V> {

  private var basEView: V? = null

    /**Attach the view To Presenter*/
    override fun onAttach(baseView: V) {
        basEView = baseView
    }

    /**Detach The View From Presenter*/
    override fun onDetach() {
        basEView = null
    }

    /**For Get the view from Presenter*/
    fun getBaseView(): V? {
        return basEView
    }


}