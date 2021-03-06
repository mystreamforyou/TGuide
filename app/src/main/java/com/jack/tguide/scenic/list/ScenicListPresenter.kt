package com.jack.tguide.scenic.list

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

class ScenicListPresenter : BaseMvpPresenter<ScenicListView>() {

    fun getScenics(isRefresh: Boolean, count: Int) {
        DataApi.IMPL.getScenics(0).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Response<ArrayList<Scenic>>> {
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onComplete() {
                        if (isViewAttached())
                            if (isRefresh) getView()!!.showRefreshEnd()
                            else getView()!!.showLoadMoreEnd()
                    }

                    override fun onError(e: Throwable) {
                        if (isViewAttached()) getView()!!.showError(e.message)
                    }

                    override fun onNext(value: Response<ArrayList<Scenic>>) {
                        if (isViewAttached()) getView()!!.setData(isRefresh, value.data)
                    }
                })

    }

}