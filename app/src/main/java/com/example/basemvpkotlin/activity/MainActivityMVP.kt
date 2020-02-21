package com.example.basemvpkotlin.activity

import com.example.basemvpkotlin.base.IBasePresenter
import com.example.basemvpkotlin.base.IBaseView

interface MainActivityMVP {

    interface IView : IBaseView {

    }

    interface IPresenter<V : IView> : IBasePresenter<V> {

    }

    interface IRepository {

    }

}