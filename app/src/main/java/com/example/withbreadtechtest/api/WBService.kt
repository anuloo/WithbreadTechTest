package com.example.withbreadtechtest.api

import com.example.withbreadtechtest.data.WBResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WBService {
    @GET("v2/venues/search?")
    suspend fun getCurrentData(
        @Query("ll") ll: String,
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
        @Query("v") apiVersion: String
    ): Response<WBResponse>

    companion object {
        var BaseUrl = "https://api.foursquare.com/"
        var retrofitService: WBService? = null
        fun getInstance() : WBService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(WBService::class.java)
            }
            return retrofitService!!
        }

    }
}