package com.jack.common.rest

import android.util.Log
import com.jack.common.utils.ScreenUtils
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody


/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/20
 **/

class LoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()

        val t1 = System.nanoTime()
        Log.i("LoggingInterceptor", String.format("Sending request : %s on %s%n%s",
                request.url(), chain.connection(), request.headers()))
        val newRequestBuilder = request.newBuilder()
                .header("resolution", ScreenUtils.screenWidth.toString() + "*" + ScreenUtils.screenHeight.toString())
                .header("dpi", ScreenUtils.density.toString())
        request = newRequestBuilder.build()
        var response: Response = chain.proceed(request)
        val t2 = System.nanoTime()

        Log.i("LoggingInterceptor", String.format("Received response header : %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6, response.headers()))
        Log.i("LoggingInterceptor", "---------------------------------------------------------------")
        //这里不能直接使用response.body().string()的方式输出日志
        //因为response.body().string()之后，response中的流会被关闭，程序会报错，我们需要创建出一
        //个新的response给应用层处理
        val responseBody: ResponseBody = response.peekBody(10 * 1024 * 1024)
        Log.i("LoggingInterceptor", String.format("Received response body length : %s", responseBody.contentLength()))
        Log.i("LoggingInterceptor", String.format("Received response body : %s", responseBody.string()))
        Log.i("LoggingInterceptor", "---------------------------------------------------------------")
        return response
    }
}