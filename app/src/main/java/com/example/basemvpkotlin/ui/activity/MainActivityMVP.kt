package com.example.basemvpkotlin.ui.activity

import com.example.basemvpkotlin.ui.base.IBasePresenter
import com.example.basemvpkotlin.ui.base.IBaseView

interface MainActivityMVP {

    interface IView : IBaseView {

    }

    interface IPresenter<V : IView> : IBasePresenter<V> {

    }

    interface IRepository {

    }

}