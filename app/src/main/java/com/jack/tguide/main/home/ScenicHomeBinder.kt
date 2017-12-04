package com.jack.tguide.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jack.common.bean.Scenic
import com.jack.tguide.R
import com.jack.tguide.base.BaseBinder
import com.jack.tguide.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_scenic.view.*

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/23
 **/

class ScenicHomeBinder : BaseBinder<Scenic>() {
    override fun renderView(holder: BaseViewHolder, itemView: View, item: Scenic) {
        itemView.sceneryImage.setImageURI(item.mainImage)
        itemView.sceneryName.text = item.businessName
        itemView.sceneryDes.text = item.summary
    }

    override fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup): BaseViewHolder {
        val view = inflater.inflate(R.layout.item_home_recommendscenic, parent, false)
        return BaseViewHolder(view)
    }
}