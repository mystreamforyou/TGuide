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
        const val scenicListUrl = "mocApi/list.php?_ijt=csqqc6nps3c31qfl7a02jg75on"
        const val scenicDetalUrl = "mocApi/scenic_detail.php?_ijt=vt52n89j6m1tqc07n2tm1orfpo"
        val IMPL: DataApi = RestUtils.retrofitInstance!!.create(DataApi::class.java)
    }

    @FormUrlEncoded
    @POST(scenicListUrl)
    fun getScenics(@Field("default") de: Int): Observable<Response<ArrayList<Scenic>>>

    @FormUrlEncoded
    @POST(scenicDetalUrl)
    fun getScenicDetail(@Field("scenicId") id: String): Observable<Response<ScenicDetail>>

}