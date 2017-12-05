package com.jack.tguide

import android.app.Application
import android.app.Service
import android.content.Context
import android.os.Vibrator
import com.baidu.mapapi.SDKInitializer
import com.facebook.drawee.backends.pipeline.Fresco
import com.jack.common.rest.RestUtils
import com.jack.common.utils.ScreenUtils
import com.jack.tguide.citylist.service.LocationService


/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/16
 **/

class App : Application() {

    companion object {
        var locationService: LocationService? = null
        var mVibrator: Vibrator? = null
        var mContext: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
        ScreenUtils.init(this)
        RestUtils.init(this)
        Fresco.initialize(this)

        /***
         * 初始化定位sdk，建议在Application中创建
         */
        locationService = LocationService(applicationContext)
        mVibrator = applicationContext.getSystemService(Service.VIBRATOR_SERVICE) as Vibrator
        SDKInitializer.initialize(applicationContext)
    }

}