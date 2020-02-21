package com.example.basemvpkotlin.base

import android.app.Activity
import android.app.AlertDialog
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.basemvpkotlin.R
import com.example.basemvpkotlin.utility.ConnectivityReceiver
import com.example.basemvpkotlin.utility.NetworkSchedulerService
import com.google.android.material.snackbar.Snackbar


abstract class BaseActivity : AppCompatActivity(), IBaseView {

    abstract fun getLayoutRes(): Int
    abstract fun getFragmentContainerId(): Int

    private var snackBar: Snackbar? = null


    /*override fun isInternetAvailable(context: Context): Boolean {
        var result= false
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cm?.run {
                cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                    result = when {
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                        else -> false
                    }
                }
            }
        } else {
            cm?.run {
                cm.activeNetworkInfo?.run {
                    if (type == ConnectivityManager.TYPE_WIFI) {
                        result = true
                    } else if (type == ConnectivityManager.TYPE_MOBILE) {
                        result = true
                    }
                }
            }
        }
        return result
    }*/

    override fun getBaseContext(): Context {
        return super.getBaseContext()
    }

    override fun showSettingsDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Need Permissions")
        builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.")
        builder.setPositiveButton(
            "GOTO SETTINGS"
        ) { dialog, _ ->
            dialog.cancel()
            openSettings()
        }
        builder.setNegativeButton(
            "Cancel"
        ) { dialog, _ ->
            dialog.cancel()
        }
        builder.show()
    }

    override fun openSettings() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri = Uri.fromParts("package", packageName, null)
        intent.data = uri
        startActivityForResult(intent, 101)
    }


    /*Total Displayed Message Status*/
    override fun onSuccess(msg: String) {
    }

    override fun onError(msg: String) {
    }

    override fun onFailed(msg: String) {
    }




    override fun enableBack() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun disableBack() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
    }

    override fun setTitle(msg: String) {
        supportActionBar?.title = msg
    }

    override fun setSubTitle(msg: String) {
        supportActionBar?.title = msg
    }

    override fun onAttachSwipeRefreshLayout(swipeRefreshLayout: SwipeRefreshLayout) {

    }

    override fun setSwipeListener(listener: SwipeRefreshLayout.OnRefreshListener) {

    }

    override fun showSnackBar(view: View?, msg: CharSequence?, context: Context?, duration: Int) {
        when (duration) {
            -1 -> {
                snackBar = Snackbar.make(view!!, msg!!, Snackbar.LENGTH_SHORT)
                snackBar?.setActionTextColor(ContextCompat.getColor(context!!, R.color.colorAccent))
                snackBar?.show()
            }
            0 -> {
                snackBar = Snackbar.make(view!!, msg!!, Snackbar.LENGTH_LONG)
                snackBar?.setActionTextColor(ContextCompat.getColor(context!!, R.color.colorAccent))
                snackBar?.show()
            }
            else -> {
                snackBar = Snackbar.make(view!!, msg!!, Snackbar.LENGTH_INDEFINITE)
                snackBar?.setActionTextColor(ContextCompat.getColor(context!!, R.color.colorAccent))
                snackBar?.setAction("Dismiss") {
                    snackBar?.dismiss()
                }
                snackBar?.show()
            }
        }
    }

    /*override fun initializeSnackBar(view: View) {
        snackbar = Snackbar.make(view, "Please try again", Snackbar.LENGTH_LONG)

    }

    override fun showSnackBarMessage(message: String) {
        snackbar?.setText(message)
        snackbar?.setAction("Dismiss") {
            snackbar?.dismiss()
        }
        snackbar?.show()
    }*/

    override fun onAttachFragment(fragment: Fragment?, tag: String) {
        when (fragment) {
            null -> return
            else -> {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.add(getFragmentContainerId(), fragment, tag)
                //fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.commit()
            }
        }
    }

    override fun onReplaceFragment(fragment: Fragment, tag: String, addToBackStack: Boolean) {

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(getFragmentContainerId(), fragment, tag)
        //fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit()


    }

    override fun onDetachFragment(tag: String) {
        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentByTag(tag)

        val fragmentTransaction = fragmentManager.beginTransaction()
        fragment?.let { fragmentTransaction.remove(it) }
    }

    override fun removeAllBackStackFragments() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun hideKeyBoard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun showProgressLoader() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgressLoader() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Full Screen Not Title Bar
        /*requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )*/
        /*Set ContentView*/
        setContentView(getLayoutRes())
        /*ScheduleJob with network connection*/
        scheduleJob()
        checkConnection()
    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private fun scheduleJob() {
        val myJob =
            JobInfo.Builder(0, ComponentName(this, NetworkSchedulerService::class.java))
                .setRequiresCharging(true)
                .setMinimumLatency(1000)
                .setOverrideDeadline(2000)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setPersisted(true)
                .build()
        val jobScheduler =
            getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        jobScheduler.schedule(myJob)
    }

    // Method to manually check connection status
    private fun checkConnection() {
        val isConnected = ConnectivityReceiver.isConnected(context = applicationContext)
        val message = if (isConnected)
            "Connected to Internet"
        else
            "No Internet Connection"
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        // A service can be "started" and/or "bound". In this case, it's "started" by this Activity
        // and "bound" to the JobScheduler (also called "Scheduled" by the JobScheduler). This call
        // to stopService() won't prevent scheduled jobs to be processed. However, failing
        // to call stopService() would keep it alive indefinitely.
        stopService(Intent(this, NetworkSchedulerService::class.java))
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
        // Start service and provide it a way to communicate with this class.
        val startServiceIntent = Intent(this, NetworkSchedulerService::class.java)
        startService(startServiceIntent)
    }
}