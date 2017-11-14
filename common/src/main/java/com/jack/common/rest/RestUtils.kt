package com.jack.common.rest

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.paperdb.Paper
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/16
 **/

object RestUtils {

    private val RESPONSE_CACHE = "netCache"

    private val RESPONSE_CACHE_SIZE = (10 * 1024 * 1024).toLong()

    private val HTTP_CONNECT_TIMEOUT = (1000 * 30).toLong()

    private val HTTP_READ_TIMEOUT = HTTP_CONNECT_TIMEOUT

    private const val HOST_GANK: String = "http://ic.snssdk.com/api/news/feed/v66/"
    var retrofitInstance: Retrofit? = null
    var CONTEXT: Context? = null
    var CLIENT: OkHttpClient? = null
    var GSON: Gson? = null


    fun init(context: Context) {
        RestUtils.CONTEXT = context.applicationContext
        GSON = GsonBuilder().create()
        retrofitInstance = Retrofit.Builder()
                .baseUrl(HOST_GANK)
                .addConverterFactory(GsonConverterFactory.create(GSON))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient(context))
                .build()
        Paper.init(context)
    }

    internal fun getOkHttpClient(context: Context): OkHttpClient {
        val cacheDir = File(context.cacheDir, RESPONSE_CACHE)
        val builder = OkHttpClient.Builder()
        builder.cache(Cache(cacheDir, RESPONSE_CACHE_SIZE))
                .connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(HTTP_READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .addInterceptor(getTokenInterceptor())
        if (true) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logging)
        }

        return builder.build()
    }


    private fun getTokenInterceptor(): Interceptor {
        return LoggingInterceptor()
    }
}