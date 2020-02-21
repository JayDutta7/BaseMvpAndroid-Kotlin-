package com.example.basemvpkotlin.database.sharedPreference

import android.content.Context
import android.content.SharedPreferences
import com.example.basemvpkotlin.database.statickt.StaticVal.Companion.applicationName


class SharedPreferenceKt(context: Context){

    private val sharedPref: SharedPreferences = context.getSharedPreferences(applicationName,
        Context.MODE_PRIVATE)
    //Getting SharedPreference
    fun providePreferences(): SharedPreferences {
        return sharedPref
    }
}
