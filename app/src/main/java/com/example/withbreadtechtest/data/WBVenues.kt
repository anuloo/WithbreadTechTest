package com.example.withbreadtechtest.data

import com.google.gson.annotations.SerializedName

data class WBVenues(
    @SerializedName("venues") val venues : List<WBVenue>)
