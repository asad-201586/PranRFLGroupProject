package com.app.pranrflgroupproject.view_model

import androidx.lifecycle.liveData
import com.app.pranrflgroupproject.network.Resource
import com.app.pranrflgroupproject.repo.BaseViewModel
import java.lang.Exception

class HomeViewModel: BaseViewModel() {
    fun getHomeData() = liveData {
        try {
            emit(Resource.Loading)
            val data = getHomeRepo().getHomeData()
            emit(Resource.Success(data))
        }
        catch (exception: Exception) {
            emit(Resource.Error(exception.localizedMessage))
        }
    }
}