package com.jack.tguide.scenic.detail

import com.jack.common.bean.ScenicDetail
import com.jack.tguide.mvp.BaseMvpView

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/17
 **/

interface ScenicView : BaseMvpView {
    fun showLoadStart()

    fun setData(data: ScenicDetail)

    fun showLoadEnd()

}