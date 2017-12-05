package com.jack.tguide

import android.app.Application
import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco
import com.jack.common.rest.RestUtils
import com.jack.common.utils.ScreenUtils

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/16
 **/

class App : Application() {

    companion object {
        var mContext: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
        ScreenUtils.init(this)
        RestUtils.init(this)
        Fresco.initialize(this)
    }

}