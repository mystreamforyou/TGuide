package com.jack.tguide.main.home

import android.os.Bundle
import android.view.View
import com.jack.tguide.R
import com.jack.tguide.base.BaseMvpFragment

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/17
 **/

class HomeFragment : BaseMvpFragment<HomeView, HomePresenter>(), HomeView {
    override val mResId: Int get() = R.layout.fragment_home
    override val mPresenter: HomePresenter get() = HomePresenter()

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
        initView()
    }

    private fun initView() {
    }

}