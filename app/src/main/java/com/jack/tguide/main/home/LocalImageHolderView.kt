package com.jack.tguide.main.home

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bigkoo.convenientbanner.holder.Holder

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/17
 **/

class LocalImageHolderView : Holder<Int> {

    private lateinit var imageView: ImageView

    override fun createView(context: Context): View {
        imageView = ImageView(context)
        imageView.scaleType = ImageView.ScaleType.FIT_XY
        return imageView
    }

    override fun UpdateUI(context: Context, position: Int, data: Int) {
        imageView.setImageResource(data)
    }

}