package com.jack.tguide.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import com.jack.tguide.R

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/11/23
 **/

class RecyclerDivider(context: Context) : RecyclerView.ItemDecoration() {

    /**
     * item之间分割线的size，默认为1
     */
    private val mItemSize = 10

    /**
     * 绘制item分割线的画笔，和设置其属性
     * 来绘制个性分割线
     */
    private lateinit var mPaint: Paint

    var context: Context

    /**
     * 构造方法传入布局方向，不可不传
     *
     * @param context
     * @param orientation
     */
    init {
        this.context = context
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint.color = context.resources.getColor(R.color.color_line)
        /*设置填充*/
        mPaint.style = Paint.Style.FILL
        mPaint.strokeWidth = mItemSize.toFloat()
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        super.onDraw(c, parent, state)
        drawVertical(c, parent)
    }

    /**
     * 设置item分割线的size
     *
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        outRect.set(0, 0, 0, mItemSize)
    }

    /**
     * 绘制纵向 item 分割线
     *
     * @param canvas
     * @param parent
     */
    private fun drawVertical(canvas: Canvas, parent: RecyclerView) {
        val left = parent.paddingLeft
        val right = parent.measuredWidth - parent.paddingRight
        val childSize = parent.childCount
        for (i in 0 until childSize) {
            val child = parent.getChildAt(i)
            val layoutParams = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + layoutParams.bottomMargin
            val bottom = top + mItemSize
            canvas.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), mPaint)
        }
    }

}