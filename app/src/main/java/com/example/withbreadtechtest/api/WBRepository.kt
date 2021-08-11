package com.example.withbreadtechtest.api

class WBRepository constructor(private val retrofitService: WBService) {

    companion object {
        var api_version = "20120808"
        var client_id = "JOWNR2DUBC5CBXWMYHY4UQXE3PZWMXAOQWCSXOFEYL1ROUTO"
        var client_secret = "AKS4LWGOI5P0Q1CZDDC4I1XEORC0BOXWDGKXWNTL4ENAEDEY"
        var latAndLong = "51.421623, -0.173049"
    }

    suspend fun getAllVenues() = retrofitService.getCurrentData(latAndLong, client_id, client_secret, api_version)

}