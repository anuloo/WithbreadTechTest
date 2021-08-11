package com.example.withbreadtechtest.data

import com.google.gson.annotations.SerializedName

data class WBVenue(
    @SerializedName("id") val id : String,
    @SerializedName("name") val name : String,
    @SerializedName("location") val location : WBLocation,
    @SerializedName("categories") val categories : List<WBCategory>
)
