package com.example.basemvpkotlin.fragment

import com.example.basemvpkotlin.base.IBasePresenter
import com.example.basemvpkotlin.base.IBaseView

interface MainFragmentMVP {
    interface IView : IBaseView {

    }

    interface IPresenter<V : IView> : IBasePresenter<V> {

    }

    interface IRepository {

    }
}