package com.jack.tguide.scenic.detail

import android.os.Bundle
import android.util.Log
import com.jack.common.bean.Scenic
import com.jack.tguide.R
import com.jack.tguide.base.BaseAdapter
import com.jack.tguide.base.BaseMvpActivity

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/23
 **/

class ScenicActivity : BaseMvpActivity<ScenicView, ScenicPresenter>(), ScenicView {
    override fun showRefreshEnd() {
    }

    override fun showLoadMoreEnd() {
    }

    override var mPresenter: ScenicPresenter = ScenicPresenter()

    private lateinit var adapter: BaseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scenic_detail)
        initView()
    }

    fun initView() {
        initData()
    }

    private fun initData() {
    }

    override fun setData(isRefresh: Boolean, datas: List<Scenic>) {
        Log.i("DataApi", "isRefresh " + isRefresh + " Data size " + datas.size)
        if (isRefresh) {
            adapter.update(datas)
        } else {
            adapter.add(datas)
        }
    }
}