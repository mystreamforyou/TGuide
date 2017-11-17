package com.jack.tguide.main

import android.app.Fragment
import android.app.FragmentTransaction
import android.os.Bundle
import android.widget.RadioGroup
import com.jack.tguide.R
import com.jack.tguide.base.BaseMvpActivity
import com.jack.tguide.main.home.HomeFragment
import com.jack.tguide.main.mine.MineFragment
import com.jack.tguide.main.news.NewsFragment
import com.jack.tguide.main.scenic.ScenicFragment
import com.jack.tguide.mvp.BaseMvpPresenter
import com.jack.tguide.mvp.BaseMvpView
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/16
 **/

class MainActivity : BaseMvpActivity<BaseMvpView, BaseMvpPresenter<BaseMvpView>>() {

    override var mPresenter: BaseMvpPresenter<BaseMvpView> = BaseMvpPresenter()

    private lateinit var homeFragment: Fragment
    private lateinit var scenicFragment: Fragment
    private lateinit var newsFragment: Fragment
    private lateinit var mineFragment: Fragment

    private var currentFragment: Fragment? = null

    private val onCheckedChangeListener = RadioGroup.OnCheckedChangeListener { group, checkedId ->
        when (checkedId) {
            R.id.tab_home -> {
                showFragment(homeFragment)
            }
            R.id.tab_business -> {
                showFragment(scenicFragment)
            }
            R.id.tab_found -> {
                showFragment(newsFragment)
            }
            R.id.tab_mine -> {
                showFragment(mineFragment)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        tabGroup.setOnCheckedChangeListener(onCheckedChangeListener)
        homeFragment = HomeFragment.newInstance()
        scenicFragment = ScenicFragment.newInstance()
        newsFragment = NewsFragment.newInstance()
        mineFragment = MineFragment.newInstance()
        showFragment(homeFragment)
    }

    private fun showFragment(fragment: Fragment) {
        val ft: FragmentTransaction = fragmentManager.beginTransaction()
        if (currentFragment != fragment) {
            if (currentFragment != null) ft.hide(currentFragment)
            currentFragment = fragment
            if (fragment.isAdded) {
                ft.show(fragment)
            } else {
                ft.add(R.id.content, fragment)
            }
            ft.commit()
        }
    }
}