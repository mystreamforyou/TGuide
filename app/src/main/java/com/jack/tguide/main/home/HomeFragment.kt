package com.jack.tguide.main.home

import android.os.Bundle
import android.view.View
import com.jack.tguide.R
import com.jack.tguide.base.BaseMvpFragment
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/17
 **/

class HomeFragment : BaseMvpFragment<HomeView, HomePresenter>(), HomeView {
    override val mResId: Int get() = com.jack.tguide.R.layout.fragment_home
    override val mPresenter: HomePresenter get() = HomePresenter()

    private var localImages: MutableList<Int> = ArrayList()
    private var titles: ArrayList<String> = ArrayList()

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
    }

    private fun initView() {
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

    override fun onPause() {
        super.onPause()
        banner.stopAutoPlay()
    }

    override fun onResume() {
        super.onResume()
        banner.startAutoPlay()
    }

}