package com.jack.tguide.scenic.detail

import android.os.Bundle
import android.util.Log
import com.jack.common.bean.ScenicDetail
import com.jack.tguide.R
import com.jack.tguide.base.BaseMvpActivity

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/23
 **/

class ScenicActivity : BaseMvpActivity<ScenicView, ScenicPresenter>(), ScenicView {
    override fun showLoadStart() {
    }

    override fun showLoadEnd() {
    }

    override var mPresenter: ScenicPresenter = ScenicPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scenic_detail)
        initView()
    }

    fun initView() {
        initData()
    }

    private fun initData() {
        mPresenter.getScenicDetail("1")
    }

    override fun setData(data: ScenicDetail) {
        Log.i("DataApi", "ScenicDetail " + data.toString())
    }
}