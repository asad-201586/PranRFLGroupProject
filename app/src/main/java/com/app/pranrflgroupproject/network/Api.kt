package com.app.pranrflgroupproject.network
import com.app.pranrflgroupproject.app.App
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Api {
    fun createService(): ApiInterface {
        val timeOut = 3L
        val unit = TimeUnit.MINUTES

        //val interceptor = HttpLoggingInterceptor()
        //interceptor.level = HttpLoggingInterceptor.Level.BODY

        val interceptor = ChuckerInterceptor.Builder(App.globalContext)
            .apply { maxContentLength(10000) }
            .build()

        val client = OkHttpClient().newBuilder()
            .callTimeout(timeOut,unit)
            .connectTimeout(timeOut,unit)
            .readTimeout(timeOut,unit)
            .writeTimeout(timeOut,unit)
            .addInterceptor(interceptor)

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .client(client.build())
            .build()

        return retrofit.create(ApiInterface::class.java)
    }

    companion object {
        const val BASE_URL = "https://dev-api.osudpotro.com/api/v1/"
        private val instance by lazy { Api().createService() }
        fun getService() = instance
    }
}

fun apiHitter(): ApiInterface {
    return Api.getService()
}