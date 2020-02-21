package com.example.basemvpkotlin.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("Ack")
    @Expose
    val acK: Int,
    @SerializedName("Message")
    @Expose
    val message: String
)