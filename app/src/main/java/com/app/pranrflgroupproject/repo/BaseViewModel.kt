package com.app.pranrflgroupproject.repo

import androidx.lifecycle.ViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

open class BaseViewModel: ViewModel(), KoinComponent {
    private val homeRepository: HomeRepository by inject()

    fun getHomeRepo() = homeRepository
}