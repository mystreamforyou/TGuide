package com.jack.tguide.base

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/23
 **/

abstract class ItemBinder<T : Any, VH : RecyclerView.ViewHolder> {
    var itemClickListener: ((item: T, position: Int) -> Unit)? = null

    var extendListener1: ((item: T) -> Unit)? = null
    var extendListener2: ((item: T) -> Unit)? = null

    lateinit var adapter: BaseAdapter

    abstract fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup): VH

    abstract fun bindViewHolder(holder: VH, item: T)

    fun clickWith(listener: (item: T, position: Int) -> Unit) = apply {
        itemClickListener = listener
    }

    fun addExtendListener1(listener: (item: T) -> Unit) = apply {
        extendListener1 = listener
    }

    fun addExtendListener2(listener: (item: T) -> Unit) = apply {
        extendListener2 = listener
    }
}

abstract class BaseBinder<T : Any> : ItemBinder<T, BaseViewHolder>() {
    override fun bindViewHolder(holder: BaseViewHolder, item: T) {
        renderView(holder, holder.itemView, item)
    }

    abstract fun renderView(holder: BaseViewHolder, itemView: View, item: T)
}