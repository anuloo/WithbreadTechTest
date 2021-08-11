package com.example.withbreadtechtest.data

import com.google.gson.annotations.SerializedName

data class WBLocation(
    @SerializedName("lat") val lat : Double,
    @SerializedName("lng") val lng : Double,
    @SerializedName("distance") val distance : Int,
    @SerializedName("country") val country : String)
