package com.jack.common.bean

import com.google.gson.annotations.SerializedName

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/16
 **/
data class ScenicDetail(
        @SerializedName("ScenicId") val scenicId: String,
        @SerializedName("BusinessId") val businessId: String,
        @SerializedName("ScenicName") val scenicName: String,
        @SerializedName("Longitude") val longitude: String,
        @SerializedName("Latitude") val latitude: String,
        @SerializedName("Address") val address: String,
        @SerializedName("Summary") val summary: String,
        @SerializedName("LinkNumber") val linkNumber: String,
        @SerializedName("Traffic") val traffic: String,
        @SerializedName("MapUrl") val mapUrl: String,
        @SerializedName("OpeningHours") val openingHours: String,
        @SerializedName("ImageList") val imageList: String
)