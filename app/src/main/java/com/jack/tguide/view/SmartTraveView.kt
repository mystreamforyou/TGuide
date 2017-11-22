package com.jack.tguide.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.jack.tguide.R
import kotlinx.android.synthetic.main.view_smart_trave.view.*

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/22
 **/

class SmartTraveView : RelativeLayout {

    constructor(context: Context) : super(context, null) {
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs, 0) {
        val t = context.obtainStyledAttributes(attrs, R.styleable.stv_styleable)
        val src = t.getResourceId(R.styleable.stv_styleable_stv_src, 0)
        val tit = t.getString(R.styleable.stv_styleable_stv_tit)
        val des = t.getString(R.styleable.stv_styleable_stv_des)
        View.inflate(context, R.layout.view_smart_trave, this)

        actionIV.setImageResource(src)
        titTV.text = tit
        desTV.text = des
    }


    public fun updateUI(title: String, des: String) {

    }

}