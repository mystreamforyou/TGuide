package com.jack.tguide

import android.app.Activity
import android.content.Intent
import com.jack.tguide.scenic.detail.ScenicActivity
import com.jack.tguide.scenic.list.ScenicListActivity

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/27
 **/

object IntentStart {

    fun startScenicList(act: Activity) {
        val i = Intent(act, ScenicListActivity::class.java)
        act.startActivity(i)
    }
    fun startScenicDetail(act: Activity) {
        val i = Intent(act, ScenicActivity::class.java)
        act.startActivity(i)
    }

}