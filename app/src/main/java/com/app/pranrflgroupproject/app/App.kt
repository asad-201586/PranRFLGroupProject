package com.app.pranrflgroupproject.app

import android.app.Application
import android.content.Context
import com.app.pranrflgroupproject.di.repo
import com.app.pranrflgroupproject.di.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        myApplication = this
        startKoin {
            androidContext(this@App)
            modules(listOf(viewModels, repo))
        }
    }

    companion object {

        private lateinit var myApplication: App
        private fun getApp() = myApplication

        @JvmStatic
        val globalContext: Context
        get() = getApp().applicationContext
    }
}