package com.jack.tguide.scenic.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.jack.common.bean.Scenic
import com.jack.tguide.IntentStart
import com.jack.tguide.R
import com.jack.tguide.base.BaseAdapter
import com.jack.tguide.base.BaseMvpActivity
import com.jack.tguide.scenic.ScenicContant
import com.jack.tguide.view.RecyclerDivider
import com.jcodecraeer.xrecyclerview.XRecyclerView
import kotlinx.android.synthetic.main.activity_scenic.*

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/23
 **/

class ScenicListActivity : BaseMvpActivity<ScenicListView, ScenicListPresenter>(), ScenicListView {

    override var mPresenter: ScenicListPresenter = ScenicListPresenter()

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
                    val b = Bundle()
                    b.putString(ScenicContant.SCENIC_ID, item.scenicId)
                    b.putString(ScenicContant.SCENIC_NAME, item.businessName)
                    IntentStart.startScenicDetail(this,b)
                }))
        rlvList.adapter = adapter

        rlvList.setLoadingListener(object : XRecyclerView.LoadingListener {
            override fun onLoadMore() {
                mPresenter.getScenics(false, 0)
            }

            override fun onRefresh() {
                mPresenter.getScenics(true, 0)
            }
        })
        initData()
    }

    private fun initData() {
        mPresenter.getScenics(true, 0)
    }

    override fun showRefreshEnd() {
        rlvList.refreshComplete()
    }

    override fun setData(isRefresh: Boolean, datas: List<Scenic>) {
        Log.i("DataApi", "isRefresh " + isRefresh + " Data size " + datas.size)
        if (isRefresh) {
            adapter.update(datas)
        } else {
            adapter.add(datas)
        }
    }

    override fun showLoadMoreEnd() {
        rlvList.loadMoreComplete()
    }
}