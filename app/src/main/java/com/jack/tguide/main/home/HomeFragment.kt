package com.jack.tguide.main.home

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bigkoo.convenientbanner.ConvenientBanner
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator
import com.jack.tguide.R
import com.jack.tguide.base.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_home.*
import android.widget.ImageView.ScaleType
import com.bigkoo.convenientbanner.holder.Holder


/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/17
 **/

class HomeFragment : BaseMvpFragment<HomeView, HomePresenter>(), HomeView {
    override val mResId: Int get() = R.layout.fragment_home
    override val mPresenter: HomePresenter get() = HomePresenter()

    private var localImages: ArrayList<Int> = ArrayList()

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
        var a= CBViewHolderCreator {
            @Override
            fun createHolder(): LocalImageHolderView {
                return LocalImageHolderView()
            }
        }

        convenientBanner.setPages(a, localImages)
                .setPageIndicator(intArrayOf(R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused))
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
//        convenientBanner.setManualPageable(false);//设置不能手动影响

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
    }

}