package com.app.pranrflgroupproject.di

import com.app.pranrflgroupproject.repo.HomeRepository
import com.app.pranrflgroupproject.view_model.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel { HomeViewModel() }
}

val repo = module {
    factory { HomeRepository() }
}