package com.jack.common.bean

import com.google.gson.annotations.SerializedName

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/16
 **/

class Response<T>(
        @SerializedName("data") val data: T,
        @SerializedName("code") val code: Int,
        @SerializedName("message") val message: String
)