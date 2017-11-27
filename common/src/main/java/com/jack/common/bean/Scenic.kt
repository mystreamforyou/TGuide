package com.jack.common.bean

import com.google.gson.annotations.SerializedName

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/16
 **/
data class Scenic(
        @SerializedName("ScenicId") val scenicId: String,
        @SerializedName("BusinessName") val businessName: String,
        @SerializedName("Summary") val summary: String,
        @SerializedName("DetailUrl") val detailUrl: String,
        @SerializedName("MainImage") val mainImage: String
)