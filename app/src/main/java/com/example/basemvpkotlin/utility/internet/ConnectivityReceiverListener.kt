package com.example.basemvpkotlin.utility.internet

interface ConnectivityReceiverListener {
    fun onNetworkConnectionChanged(isConnected: Boolean)
}