package com.jack.tguide.scenic.detail

import android.util.Log
import com.jack.common.api.DataApi
import com.jack.common.bean.Response
import com.jack.common.bean.ScenicDetail
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

class ScenicPresenter : BaseMvpPresenter<ScenicView>() {

    fun getScenicDetail(scenicId: String) {
        DataApi.IMPL.getScenicDetail(scenicId).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Response<ScenicDetail>> {
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onComplete() {
                        if (isViewAttached())
                            getView()!!.showLoadEnd()
                    }

                    override fun onError(e: Throwable) {
                        Log.i("onError", "ScenicDetail " + e.message)
                        if (isViewAttached()) getView()!!.showError(e.message)
                    }

                    override fun onNext(value: Response<ScenicDetail>) {
                        if (isViewAttached()) getView()!!.setData(value.data)
                    }
                })

    }

}