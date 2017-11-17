package com.jack.tguide.main.news

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

class NewsFragment : BaseMvpFragment<NewsView, NewsPresenter>(), NewsView {
    override val mPresenter: NewsPresenter
        get() = NewsPresenter()
    override val mResId: Int
        get() = R.layout.fragment_news

    companion object {
        fun newInstance(): NewsFragment {
            val args = Bundle()
            val fragment = NewsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}