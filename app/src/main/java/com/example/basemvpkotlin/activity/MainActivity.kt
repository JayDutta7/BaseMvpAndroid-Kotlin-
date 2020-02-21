package com.example.basemvpkotlin.activity

import android.os.Bundle
import android.util.Log
import com.example.basemvpkotlin.R
import com.example.basemvpkotlin.base.BaseActivity

class MainActivity : BaseActivity(),MainActivityMVP.IView {


    private lateinit var mainActivityPresenter:MainActivityPresenter<MainActivityMVP.IView>

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    /*Attach Layout*/
    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    /*Attach Fragment Container Layout*/
    override fun getFragmentContainerId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*initialize presenter*/
        mainActivityPresenter=MainActivityPresenter()
        /*Attach the View*/
        mainActivityPresenter.onAttach(this)


    }
}
