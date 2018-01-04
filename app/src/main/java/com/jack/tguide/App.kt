package com.jack.tguide

import android.app.Application
import android.content.Context
import android.os.Vibrator
import com.baidu.mapapi.CoordType
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

        // 在使用 SDK 各组间之前初始化 context 信息，传入 ApplicationContext
        SDKInitializer.initialize(this)
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL)

        /***
         * 初始化定位sdk，建议在Application中创建
         */
        locationService = LocationService(applicationContext)
//        mVibrator = applicationContext.getSystemService(Service.VIBRATOR_SERVICE) as Vibrator
//        SDKInitializer.initialize(applicationContext)
    }

}