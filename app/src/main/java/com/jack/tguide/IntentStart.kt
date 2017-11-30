package com.jack.tguide

import android.app.Activity
import android.content.Intent
import android.os.Bundle
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

    fun startScenicDetail(act: Activity, bundle: Bundle) {
        val i = Intent(act, ScenicActivity::class.java)
        i.putExtra("bundle",bundle)
        act.startActivity(i)
    }

}