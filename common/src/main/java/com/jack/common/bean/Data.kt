package com.jack.common.bean

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/16
 **/

class Data(
        @SerializedName("content") val mJson: String,
        @SerializedName("code") val code: String) {
    private var mDuanzi: Duanzi? = null
    private var mQutu: Qutu? = null

    fun getDuanzi(): Duanzi {
        if (mDuanzi == null) {
            mDuanzi = Gson().fromJson(mJson, Duanzi::class.java)
        }
        return mDuanzi!!
    }

    fun getQutu(): Qutu {
        if (mQutu == null) {
            mQutu = Gson().fromJson(mJson, Qutu::class.java)
        }
        return mQutu!!
    }
}