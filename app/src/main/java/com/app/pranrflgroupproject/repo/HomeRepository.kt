package com.app.pranrflgroupproject.repo

import com.app.pranrflgroupproject.network.apiHitter

class HomeRepository {
    suspend fun getHomeData() = apiHitter().getHomeData()
}