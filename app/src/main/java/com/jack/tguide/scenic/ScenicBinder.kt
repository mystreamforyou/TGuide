package com.jack.tguide.scenic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jack.common.bean.Data
import com.jack.tguide.R
import com.jack.tguide.base.BaseBinder
import com.jack.tguide.base.BaseViewHolder

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/23
 **/

class ScenicBinder : BaseBinder<Data>() {
    override fun renderView(holder: BaseViewHolder, itemView: View, item: Data) {
    }

    override fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup): BaseViewHolder {
        val view = inflater.inflate(R.layout.item_scenic, parent, false)
        return BaseViewHolder(view)
    }
}