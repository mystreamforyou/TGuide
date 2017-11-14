package com.jack.common.bean

import com.google.gson.annotations.SerializedName

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/16
 **/

class Response<T>(
        @SerializedName("data") val datas: ArrayList<T>,
        @SerializedName("feed_flag") val feedFlag: Int,
        @SerializedName("has_more") val hasMore: Boolean,
        @SerializedName("has_more_to_refresh") val hasMoreToRefresh: Boolean,
        @SerializedName("login_status") val loginStatus: Int,
        @SerializedName("message") val message: String,
        @SerializedName("post_content_hint") val postContentHint: String,
        @SerializedName("show_et_status") val showEtStatus: Int,
        @SerializedName("tips") val tips: Tips,
        @SerializedName("total_number") val totalNumber: Int
)