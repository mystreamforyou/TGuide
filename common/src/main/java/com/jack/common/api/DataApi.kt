package com.jack.common.api

import com.jack.common.bean.Response
import com.jack.common.bean.Scenic
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
        const val duanziUrl = "mocApi/list.php?_ijt=csqqc6nps3c31qfl7a02jg75on"
        val IMPL: DataApi = RestUtils.retrofitInstance!!.create(DataApi::class.java)
    }

    @FormUrlEncoded
    @POST(duanziUrl)
    fun getScenics(@Field("default") de: Int): Observable<Response<Scenic>>

}