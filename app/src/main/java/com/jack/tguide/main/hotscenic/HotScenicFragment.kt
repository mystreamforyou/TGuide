package com.jack.tguide.main.hotscenic

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

class HotScenicFragment : BaseMvpFragment<HotScenicView, HotScenicPresenter>(), HotScenicView {
    override val mPresenter: HotScenicPresenter
        get() = HotScenicPresenter()
    override val mResId: Int
        get() = R.layout.fragment_scenic

    companion object {
        fun newInstance(): HotScenicFragment {
            val args = Bundle()
            val fragment = HotScenicFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}