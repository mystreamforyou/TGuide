package com.jack.tguide.base

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.jack.tguide.mvp.BaseMvpPresenter
import com.jack.tguide.mvp.BaseMvpView

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/16
 **/

abstract class BaseMvpFragment<V : BaseMvpView, out P : BaseMvpPresenter<V>> : Fragment(), BaseMvpView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.attachView(this as V)
    }

    override fun getContext(): Context = activity

    protected abstract val mPresenter: P
    protected abstract val mResId: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(mResId, container, false)
    }

    override fun showError(error: String?) {
        Toast.makeText(activity, error, Toast.LENGTH_LONG).show()
    }

    override fun showError(stringResId: Int) {
        Toast.makeText(activity, stringResId, Toast.LENGTH_LONG).show()
    }

    override fun showMessage(srtResId: Int) {
        Toast.makeText(activity, srtResId, Toast.LENGTH_LONG).show()
    }

    override fun showMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

    protected fun toast(str: String) {
        Toast.makeText(this.activity, str, Toast.LENGTH_SHORT).show()
    }

    protected fun toast(id: Int) {
        Toast.makeText(this.activity, id, Toast.LENGTH_SHORT).show()
    }

}