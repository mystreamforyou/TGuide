package com.jack.tguide.main.scenic

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

class ScenicFragment : BaseMvpFragment<ScenicView, ScenicPresenter>(), ScenicView {
    override val mPresenter: ScenicPresenter
        get() = ScenicPresenter()
    override val mResId: Int
        get() = R.layout.fragment_scenic

    companion object {
        fun newInstance(): ScenicFragment {
            val args = Bundle()
            val fragment = ScenicFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}