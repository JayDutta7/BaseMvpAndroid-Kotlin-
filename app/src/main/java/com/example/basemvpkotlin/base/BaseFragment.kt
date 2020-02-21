package com.example.basemvpkotlin.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout


abstract class BaseFragment : Fragment(), IBaseView {

    private var baseActivity: BaseActivity? = null
    abstract fun getLayoutRes(): Int


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutRes(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        baseActivity = context as BaseActivity
    }

    /*override fun isInternetAvailable(context: Context): Boolean {
      return baseActivity?.isInternetAvailable(context)!!
    }*/



    /*override fun msgThrowable(it: Throwable) {
        baseActivity?.msgThrowable(it)
    }

    override fun msgLog(msg: Any) {
        baseActivity?.msgLog(msg)
    }*/


    override fun showProgressLoader() {
        baseActivity?.showProgressLoader()
    }

    override fun hideProgressLoader() {
        baseActivity?.hideProgressLoader()
    }

    override fun openSettings() {
        baseActivity?.openSettings()
    }

    override fun showSettingsDialog() {
        baseActivity?.showSettingsDialog()
    }

    override fun getBaseContext(): Context? {
        return context
    }

    override fun enableBack() {
        baseActivity?.enableBack()
    }

    override fun disableBack() {
        baseActivity?.disableBack()
    }

    override fun setTitle(msg: String) {
        baseActivity?.setTitle(msg)
    }

    override fun setSubTitle(msg: String) {
        baseActivity?.setSubTitle(msg)
    }

    override fun onAttachSwipeRefreshLayout(swipeRefreshLayout: SwipeRefreshLayout) {

    }

    override fun setSwipeListener(listener: SwipeRefreshLayout.OnRefreshListener) {

    }

    /*override fun initializeSnackBar(view: View) {
        baseActivity!!.initializeSnackBar(view)
    }

    override fun showSnackBarMessage(message: String) {
        baseActivity!!.showSnackBarMessage(message)
    }*/


    override fun showSnackBar(view: View?, msg: CharSequence?, context: Context?, duration: Int) {
        baseActivity?.showSnackBar(view, msg, context, duration)
    }

    override fun onAttachFragment(fragment: Fragment?, tag: String) {
        baseActivity?.onAttachFragment(fragment, tag)
    }

    override fun onReplaceFragment(fragment: Fragment, tag: String, addToBackStack: Boolean) {

        baseActivity?.onReplaceFragment(fragment, tag, addToBackStack)
    }

    override fun onDetachFragment(tag: String) {

        baseActivity?.onDetachFragment(tag)

    }

    override fun removeAllBackStackFragments() {
        baseActivity?.removeAllBackStackFragments()
    }

    override fun hideKeyBoard(view: View) {
        baseActivity?.hideKeyBoard(view)
    }

    override fun onSuccess(msg: String) {

        baseActivity?.onSuccess(msg)

    }

    override fun onError(msg: String) {

        baseActivity?.onError(msg)
    }

    override fun onFailed(msg: String) {
        baseActivity?.onFailed(msg)
    }

}