package com.jack.common.api

import com.jack.common.bean.Response
import com.jack.common.bean.Scenic
import com.jack.common.bean.ScenicDetail
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
        val IMPL: DataApi = RestUtils.retrofitInstance!!.create(DataApi::class.java)
    }

    @FormUrlEncoded
    @POST("list.php")
    fun getScenics(@Field("default") de: Int): Observable<Response<ArrayList<Scenic>>>

    @FormUrlEncoded
    @POST("scenic_detail.php")
    fun getScenicDetail(@Field("scenicId") id: String): Observable<Response<ScenicDetail>>

}