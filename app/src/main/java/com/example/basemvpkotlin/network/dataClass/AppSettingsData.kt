package com.example.basemvpkotlin.network.dataClass

import com.example.basemvpkotlin.network.BaseResponse
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AppSettingsData(
    @Expose
    val responseBase: BaseResponse,
    @SerializedName("headerColour")
    @Expose
    val headerColor: String,
    @SerializedName("headerTxtColour")
    @Expose
    val headerTxtColour: String
)