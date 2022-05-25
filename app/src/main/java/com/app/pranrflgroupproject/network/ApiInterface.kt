package com.app.pranrflgroupproject.network

import com.app.pranrflgroupproject.model.HomeDataResponse
import retrofit2.http.GET

interface ApiInterface {

    @GET("home/home_data")
    suspend fun getHomeData(): HomeDataResponse

}