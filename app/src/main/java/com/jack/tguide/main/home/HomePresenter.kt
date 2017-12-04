package com.jack.tguide.main.home

import android.util.Log
import com.jack.common.api.DataApi
import com.jack.common.bean.Response
import com.jack.common.bean.Scenic
import com.jack.tguide.mvp.BaseMvpPresenter
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/17
 **/

class HomePresenter : BaseMvpPresenter<HomeView>() {

    fun getHomeScenics() {
        DataApi.IMPL.getScenics(0).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Response<ArrayList<Scenic>>> {
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onComplete() {
                        Log.i("HomePresenter", " " + "onComplete ")
                    }

                    override fun onError(e: Throwable) {
                        Log.i("HomePresenter", " " + "onError " + e.message)
                        if (isViewAttached()) getView()!!.showError(e.message)
                    }

                    override fun onNext(value: Response<ArrayList<Scenic>>) {
                        Log.i("HomePresenter", " " + "onNext " + value.data.toString())

                        if (isViewAttached()) getView()!!.setData(value.data)
                    }
                })

    }


}