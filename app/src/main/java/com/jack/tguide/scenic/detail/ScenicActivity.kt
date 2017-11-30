package com.jack.tguide.scenic.detail

import android.os.Bundle
import android.util.Log
import com.jack.common.bean.ScenicDetail
import com.jack.tguide.R
import com.jack.tguide.base.BaseMvpActivity
import com.jack.tguide.scenic.ScenicContant
import kotlinx.android.synthetic.main.title_view_white_with_divicer.*

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/23
 **/

class ScenicActivity : BaseMvpActivity<ScenicView, ScenicPresenter>(), ScenicView {

    private var scenicId: String = "-1"

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


        initTitle()
        initData()
    }

    private fun initTitle() {
        val b: Bundle = intent.extras.get("bundle") as Bundle
        scenicId = b.get(ScenicContant.SCENIC_ID).toString()
        val scenicName = b.get(ScenicContant.SCENIC_NAME).toString()
        nav_title_tv.text = scenicName
        backbtn.setOnClickListener { finish() }
    }

    private fun initData() {
        mPresenter.getScenicDetail("1")
    }

    override fun setData(data: ScenicDetail) {
        Log.i("DataApi", "ScenicDetail " + data.toString())


    }
}