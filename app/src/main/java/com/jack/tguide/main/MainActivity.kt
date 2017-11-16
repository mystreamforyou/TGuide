package com.jack.tguide.main

import android.app.Fragment
import android.app.FragmentTransaction
import android.os.Bundle
import android.widget.RadioButton
import com.jack.tguide.R
import com.jack.tguide.base.BaseMvpActivity
import com.jack.tguide.mvp.BaseMvpPresenter
import com.jack.tguide.mvp.BaseMvpView



/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/16
 **/

class MainActivity : BaseMvpActivity<BaseMvpView, BaseMvpPresenter<BaseMvpView>>() {

    override var mPresenter: BaseMvpPresenter<BaseMvpView> = BaseMvpPresenter()

    //三个选项卡
    private val mRBtnFrist: RadioButton? = null
    private val mRBtnSecond: RadioButton? = null
    private val mRBtnThrid: RadioButton? = null

    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {


//        settingFragment = SettingFragment.newInstance()
//        showFragment(duanziFragment)
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