package com.jack.tguide.main.home

import com.jack.common.bean.Scenic
import com.jack.tguide.mvp.BaseMvpView

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/17
 **/

interface HomeView : BaseMvpView {
    fun setData(datas: List<Scenic>)

}