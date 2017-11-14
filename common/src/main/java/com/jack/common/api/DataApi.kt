package com.jack.common.api

import com.jack.common.bean.Data
import com.jack.common.bean.Response
import com.jack.common.rest.RestUtils
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/16
 **/

interface DataApi {

    companion object {
        const val duanziUrl = "?category=essay_joke&refer=1&count=20&min_behot_time=1508134722&last_refresh_sub_entrance_interval=1513664478&device_id=34657283722&ac=wifi&channel=update&aid=13&app_name=news_article&device_platform=android&language=zh&os_api=21&os_version=5.0&uuid=357784057095067&openudid=3adb68a60e783b8d&resolution=1080*1920&dpi=480"
        const val qutuUrl = "?category=image_funny&refer=1&count=20&min_behot_time=1508132712&last_refresh_sub_entrance_interval=1513662926&device_id=34657283722&ac=wifi&channel=update&app_name=news_article&device_platform=android&language=zh&os_api=21&uuid=357784057095067&openudid=3adb68a60e783b8d&resolution=1080*1920&dpi=480"
        val IMPL: DataApi = RestUtils.retrofitInstance!!.create(DataApi::class.java)
    }

    @FormUrlEncoded
    @POST(duanziUrl)
    fun getDuanzis(@Field("default") de: Int): Observable<Response<Data>>

    @FormUrlEncoded
    @POST(qutuUrl)
    fun getQutus(@Field("default") de: Int): Observable<Response<Data>>
}