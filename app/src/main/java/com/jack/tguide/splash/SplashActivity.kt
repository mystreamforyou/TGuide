package com.jack.tguide.splash

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.jack.tguide.R
import com.jack.tguide.main.MainActivity

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/16
 **/

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            val i = Intent(SplashActivity@ this, MainActivity::class.java)
            startActivity(i)
            finish()
        }, 1000)
    }
}