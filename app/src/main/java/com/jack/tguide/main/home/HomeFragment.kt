package com.jack.tguide.main.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.jack.common.bean.Scenic
import com.jack.tguide.IntentStart
import com.jack.tguide.R
import com.jack.tguide.base.BaseAdapter
import com.jack.tguide.base.BaseMvpFragment
import com.jack.tguide.citylist.CityListActivity
import com.jack.tguide.scenic.ScenicContant
import com.jack.tguide.view.RecyclerDivider
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home_functionmenu.*
import kotlinx.android.synthetic.main.fragment_homeactivity_smarttravel.*
import kotlinx.android.synthetic.main.home_search.*
import kotlinx.android.synthetic.main.view_list_header.*


/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/17
 **/

class HomeFragment : BaseMvpFragment<HomeView, HomePresenter>(), HomeView {

    override val mResId: Int = com.jack.tguide.R.layout.fragment_home
    override val mPresenter: HomePresenter = HomePresenter()

    private var localImages: MutableList<Int> = ArrayList()
    private var titles: ArrayList<String> = ArrayList()

    private lateinit var adapter: BaseAdapter

    companion object {
        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadTestDatas()
        initView()
        initListener()
        mPresenter.getHomeScenics()
    }

    private fun initListener() {
        tv_home_menu_tour.setOnClickListener {
            IntentStart.startScenicList(activity)
        }

        tv_homeactivity_city.setOnClickListener {
            //            IntentStart.startCityList(activity)
            val i = Intent(activity, CityListActivity::class.java)
            startActivityForResult(i, 2)
        }


        smartmap.setOnClickListener { IntentStart.startScenicsMap(activity) }

    }

    private fun initView() {
        initBanner()
        initListview()
    }

    private fun initListview() {
        rlvList.layoutManager = LinearLayoutManager(activity)
        rlvList.addItemDecoration(RecyclerDivider(activity))
        adapter = BaseAdapter()
                .with(Scenic::class.java, ScenicHomeBinder().clickWith({ item, _ ->
                    val b = Bundle()
                    b.putString(ScenicContant.SCENIC_ID, item.scenicId)
                    b.putString(ScenicContant.SCENIC_NAME, item.businessName)
                    IntentStart.startScenicDetail(activity, b)
                }))
        rlvList.adapter = adapter
        rlvList.setPullRefreshEnabled(false)
        rlvList.setLoadingMoreEnabled(false)

        more.setOnClickListener { IntentStart.startScenicList(activity) }
    }

    private fun initBanner() {
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
        //设置图片加载器
        banner.setImageLoader(FrescoImageLoader())
        //设置图片集合
        banner.setImages(localImages)
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default)
        //        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles)
        //        //设置自动轮播，默认为true
        banner.isAutoPlay(true)
        //        //设置轮播时间
        banner.setDelayTime(1500)
        //        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER)
        //banner设置方法全部调用完毕时最后调用
        banner.start()
    }

    private fun loadTestDatas() {
        //本地图片集合
        localImages.add(R.drawable.ic_test_0)
        localImages.add(R.drawable.ic_test_1)
        localImages.add(R.drawable.ic_test_2)
        localImages.add(R.drawable.ic_test_3)
        localImages.add(R.drawable.ic_test_4)
        localImages.add(R.drawable.ic_test_5)
        localImages.add(R.drawable.ic_test_6)

        titles.add("titles 0")
        titles.add("titles 1")
        titles.add("titles 2")
        titles.add("titles 3")
        titles.add("titles 4")
        titles.add("titles 5")
        titles.add("titles 6")
    }

    override fun setData(datas: List<Scenic>) {
        Log.i("HomeFragment", " " + " Data size " + datas.size)
        adapter.add(datas)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            tv_homeactivity_city.text = data.getStringExtra("city")
        }
    }

    override fun onPause() {
        super.onPause()
        banner.stopAutoPlay()
    }

    override fun onResume() {
        super.onResume()
        banner.startAutoPlay()
    }
}