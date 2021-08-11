package com.example.withbreadtechtest.data

import com.google.gson.annotations.SerializedName

data class WBCategory(
    @SerializedName("id") val id : String,
    @SerializedName("name") val name : String
)
