package com.jack.tguide.scenic.list

import com.jack.common.bean.Scenic
import com.jack.tguide.mvp.BaseMvpView

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/17
 **/

interface ScenicListView : BaseMvpView {
    fun showRefreshEnd()

    fun setData(isRefresh: Boolean, datas: List<Scenic>)

    fun showLoadMoreEnd()

}