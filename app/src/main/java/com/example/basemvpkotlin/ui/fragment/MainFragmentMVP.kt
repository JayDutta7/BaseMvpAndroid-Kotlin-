package com.example.basemvpkotlin.ui.fragment

import com.example.basemvpkotlin.ui.base.IBasePresenter
import com.example.basemvpkotlin.ui.base.IBaseView

interface MainFragmentMVP {
    interface IView : IBaseView {

    }

    interface IPresenter<V : IView> : IBasePresenter<V> {

    }

    interface IRepository {

    }
}