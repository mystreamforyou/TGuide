package com.jack.tguide.base

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/23
 **/

class BaseAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var inflater: LayoutInflater? = null

    val items = arrayListOf<Any>()
    val types = arrayListOf<Class<*>>()
    val binders = arrayListOf<ItemBinder<*, *>>()

    fun with(clazz: Class<*>, binder: ItemBinder<*, *>): BaseAdapter {
        if (types.contains(clazz)) {
            val index = types.indexOf(clazz)
            types.removeAt(index)
            binders.removeAt(index)
        }
        types += clazz
        binders += binder
        return this
    }

    fun add(newData: List<Any>) {
        items.addAll(newData)
        notifyDataSetChanged()
    }

    fun update(newData: List<Any>) {
        items.clear()
        items.addAll(newData)
        notifyDataSetChanged()
    }

    fun insert(item: Any, position: Int) {
        if (types.contains(item.javaClass)) {
            items.add(position, item)
            notifyItemInserted(position)
        } else {
            throw BindeException("can not find binder of this type : ${item.javaClass}")
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        val type = types.indexOf(item.javaClass)
        if (type == -1) throw BindeException(
                "can not find binder of this type : ${item.javaClass}")
        return type
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        holder?.let {
            val type = getItemViewType(position)
            val binder = binders[type]
            val item = items[position]

            binder.adapter = this
            (binder as ItemBinder<Any, RecyclerView.ViewHolder>)
                    .bindViewHolder(holder, item)

            binder.itemClickListener?.let {
                holder.itemView.setOnClickListener {
                    (binder.itemClickListener as (item: Any, position: Int) -> Unit)
                            .invoke(item, holder.adapterPosition)
                }
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        if (parent == null) throw IllegalStateException("An adapter must attach a RecyclerView")
        val binder = binders[viewType]
        inflater?.let { inflater = LayoutInflater.from(parent.context) }
        val holder = (binder as ItemBinder<Any, RecyclerView.ViewHolder>)
                .createViewHolder(inflater ?: LayoutInflater.from(parent.context), parent)

        return holder
    }

    override fun getItemCount() = items.size
}