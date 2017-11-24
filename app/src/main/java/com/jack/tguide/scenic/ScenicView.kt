package com.jack.tguide.scenic

import com.jack.common.bean.Data
import com.jack.tguide.mvp.BaseMvpView

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/17
 **/

interface ScenicView : BaseMvpView {
    fun showRefreshEnd()

    fun setData(isRefresh: Boolean, datas: List<Data>)

    fun showLoadMoreEnd()

}