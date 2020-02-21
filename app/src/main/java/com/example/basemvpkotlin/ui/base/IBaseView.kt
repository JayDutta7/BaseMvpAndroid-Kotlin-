package com.example.basemvpkotlin.ui.base

import android.content.Context
import android.view.View
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

interface IBaseView {

    //check internet is avialable or not
    //fun isInternetAvailable(context: Context): Boolean

    //Settings Dialog
    fun openSettings()
    fun showSettingsDialog()

    //Getting Base Context
    fun getBaseContext(): Context?

    //Backbutton
    fun enableBack()
    fun disableBack()

    //SetTitle
    fun setTitle(msg: String)
    fun setSubTitle(msg: String)

    //SwipeRefresh Layout
    fun onAttachSwipeRefreshLayout(swipeRefreshLayout: SwipeRefreshLayout)
    fun setSwipeListener(listener: SwipeRefreshLayout.OnRefreshListener)

    //SnackBar
    fun showSnackBar(view: View?, msg: CharSequence?, context: Context?, duration: Int)

    //Fragment
    fun onAttachFragment(@NonNull fragment: Fragment?, @NonNull tag: String)
    fun onReplaceFragment(@NonNull fragment: Fragment, @NonNull tag: String, addToBackStack: Boolean)
    fun onDetachFragment(@NonNull tag: String)
    fun removeAllBackStackFragments()

    //keyboard hide
    fun hideKeyBoard(view: View)

    //Message
    fun onSuccess(msg: String)
    fun onError(msg: String)
    fun onFailed(msg: String)

    //ProgressLoader
    fun showProgressLoader()
    fun hideProgressLoader()


}