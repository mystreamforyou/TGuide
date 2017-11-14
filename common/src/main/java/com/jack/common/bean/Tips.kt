package com.jack.common.bean

import com.google.gson.annotations.SerializedName

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/16
 **/

class Tips(
        @SerializedName("app_name") val appName: String,
        @SerializedName("display_duration") val displayDuration: String,
        @SerializedName("display_info") val displayInfo: String,
        @SerializedName("display_template") val displayTemplate: String,
        @SerializedName("download_url") val downloadUrl: String,
        @SerializedName("open_url") val openUrl: String,
        @SerializedName("package_name") val packageName: String,
        @SerializedName("type") val type: String,
        @SerializedName("web_url") val webUrl: String
)