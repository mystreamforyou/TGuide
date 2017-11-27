package com.jack.tguide.scenic

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.jack.common.bean.Scenic
import com.jack.tguide.R
import com.jack.tguide.base.BaseAdapter
import com.jack.tguide.base.BaseMvpActivity
import com.jack.tguide.view.RecyclerDivider
import com.jcodecraeer.xrecyclerview.XRecyclerView
import kotlinx.android.synthetic.main.activity_scenic.*

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/23
 **/

class ScenicActivity : BaseMvpActivity<ScenicView, ScenicPresenter>(), ScenicView {
    override fun showRefreshEnd() {
    }

    override fun setData(isRefresh: Boolean, datas: List<Scenic>) {



    }

    override fun showLoadMoreEnd() {
    }

    override var mPresenter: ScenicPresenter = ScenicPresenter()

    private lateinit var adapter: BaseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scenic)
        initView()
    }

    fun initView() {
        rlvList.layoutManager = LinearLayoutManager(this)
        rlvList.addItemDecoration(RecyclerDivider(this))
        adapter = BaseAdapter()
                .with(Scenic::class.java, ScenicBinder().clickWith({ item, _ ->
                }))
        rlvList.adapter = adapter

        rlvList.setLoadingListener(object : XRecyclerView.LoadingListener {
            override fun onLoadMore() {
                mPresenter.getDuanzis(false, 0)
            }

            override fun onRefresh() {
                mPresenter.getDuanzis(true, 0)
            }
        })
        initData()
    }

    private fun initData() {
        mPresenter.getDuanzis(true, 0)
    }
}