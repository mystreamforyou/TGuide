package com.jack.common.bean

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import paperparcel.PaperParcel

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/16
 **/
@PaperParcel
class ImageInfo(
        override val id: String,
        @SerializedName("url") val url: String,
        @SerializedName("width") val width: String,
        @SerializedName("uri") val uri: String,
        @SerializedName("height") val height: String
) : WithId, Parcelable {

    companion object {
        @JvmField
        val CREATOR = PaperParcelImageInfo.CREATOR
    }

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        PaperParcelImageInfo.writeToParcel(this, dest, flags)
    }

}