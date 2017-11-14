package com.jack.common.utils

import android.content.Context
import android.util.Log

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/24
 **/

object ScreenUtils {

    private val TAG = "ScreenUtil"

    var screenWidth: Int = 0
    var screenHeight: Int = 0

    var valueW_H: Float = 0f

    var density: Float = 0.toFloat()
    var scaleDensity: Float = 0.toFloat()

    fun dip2px(dipValue: Float): Int {
        return (dipValue * density + 0.5f).toInt()
    }

    fun px2dip(pxValue: Float): Int {
        return (pxValue / density + 0.5f).toInt()
    }

    fun sp2px(spValue: Float): Int {
        return (spValue * scaleDensity + 0.5f).toInt()
    }

    fun init(context: Context?) {
        if (null == context) {
            return
        }
        val dm = context.applicationContext.resources.displayMetrics
        screenWidth = dm.widthPixels
        screenHeight = dm.heightPixels
        density = dm.density
        valueW_H = screenWidth.toFloat() / screenHeight
        Log.d(TAG, "screenWidth=${screenWidth} screenHeight=${screenHeight} density=${density}")
    }

}