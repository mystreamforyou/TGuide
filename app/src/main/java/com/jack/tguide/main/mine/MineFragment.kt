package com.jack.tguide.main.mine

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

class MineFragment : BaseMvpFragment<MineView, MinePresenter>(), MineView {
    override val mPresenter: MinePresenter
        get() = MinePresenter()
    override val mResId: Int
        get() = R.layout.fragment_mine

    companion object {
        fun newInstance(): MineFragment {
            val args = Bundle()
            val fragment = MineFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}