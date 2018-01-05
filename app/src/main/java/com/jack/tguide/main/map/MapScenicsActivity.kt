package com.jack.tguide.main.map

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.Toast
import com.baidu.mapapi.map.*
import com.baidu.mapapi.model.LatLng
import com.baidu.mapapi.model.LatLngBounds
import com.jack.tguide.R
import kotlinx.android.synthetic.main.activity_scenics_map.*
import java.util.*

/**
 * Description: TGuide
 * Copyright  : Copyright (c) 2018
 * Author     : liujianguang
 * Date       : 2018/1/4
 **/

class MapScenicsActivity : Activity() {

    /**
     * MapView 是地图主控件
     */
    private lateinit var mBaiduMap: BaiduMap
    private var mMarkerA: Marker? = null
    private var mMarkerB: Marker? = null
    private var mMarkerC: Marker? = null
    private var mMarkerD: Marker? = null
    private var mInfoWindow: InfoWindow? = null

    // 初始化全局 bitmap 信息，不用时及时 recycle
    private var bdA = BitmapDescriptorFactory
            .fromResource(R.drawable.icon_marka)
    private var bdB = BitmapDescriptorFactory
            .fromResource(R.drawable.icon_markb)
    private var bdC = BitmapDescriptorFactory
            .fromResource(R.drawable.icon_markc)
    private var bdD = BitmapDescriptorFactory
            .fromResource(R.drawable.icon_markd)
    private var bd = BitmapDescriptorFactory
            .fromResource(R.drawable.icon_gcoding)
    private var bdGround = BitmapDescriptorFactory
            .fromResource(R.drawable.ground_overlay)

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scenics_map)
        alphaSeekBar.setOnSeekBarChangeListener(SeekBarListener())
        mBaiduMap = mMapView.map
        val msu = MapStatusUpdateFactory.zoomTo(14.0f)
        mBaiduMap.setMapStatus(msu)
        initOverlay()
        mBaiduMap.setOnMarkerClickListener { marker ->
            val button = Button(applicationContext)
            button.setBackgroundResource(R.drawable.popup)
            var listener: InfoWindow.OnInfoWindowClickListener? = null
            if (marker == mMarkerA || marker == mMarkerD) {
                button.text = "更改位置"
                button.setTextColor(Color.BLACK)
                button.width = 300

                listener = InfoWindow.OnInfoWindowClickListener {
                    val ll = marker.position
                    val llNew = LatLng(ll.latitude + 0.005,
                            ll.longitude + 0.005)
                    marker.position = llNew
                    mBaiduMap!!.hideInfoWindow()
                }
                val ll = marker.position
                mInfoWindow = InfoWindow(BitmapDescriptorFactory.fromView(button), ll, -47, listener)
                mBaiduMap!!.showInfoWindow(mInfoWindow)
            } else if (marker == mMarkerB) {
                button.text = "更改图标"
                button.setTextColor(Color.BLACK)
                button.setOnClickListener {
                    marker.icon = bd
                    mBaiduMap!!.hideInfoWindow()
                }
                val ll = marker.position
                mInfoWindow = InfoWindow(button, ll, -47)
                mBaiduMap!!.showInfoWindow(mInfoWindow)
            } else if (marker == mMarkerC) {
                button.text = "删除"
                button.setTextColor(Color.BLACK)
                button.setOnClickListener {
                    marker.remove()
                    mBaiduMap!!.hideInfoWindow()
                }
                val ll = marker.position
                mInfoWindow = InfoWindow(button, ll, -47)
                mBaiduMap!!.showInfoWindow(mInfoWindow)
            }
            true
        }
    }

    fun initOverlay() {
        // add marker overlay
        val llA = LatLng(39.963175, 116.400244)
        val llB = LatLng(39.942821, 116.369199)
        val llC = LatLng(39.939723, 116.425541)
        val llD = LatLng(39.906965, 116.401394)

        val ooA = MarkerOptions().position(llA).icon(bdA)
                .zIndex(9).draggable(true)
        if (animationBox!!.isChecked) {
            // 掉下动画
            ooA.animateType(MarkerOptions.MarkerAnimateType.drop)
        }
        mMarkerA = mBaiduMap!!.addOverlay(ooA) as Marker
        val ooB = MarkerOptions().position(llB).icon(bdB)
                .zIndex(5)
        if (animationBox!!.isChecked) {
            // 掉下动画
            ooB.animateType(MarkerOptions.MarkerAnimateType.drop)
        }
        mMarkerB = mBaiduMap!!.addOverlay(ooB) as Marker
        val ooC = MarkerOptions().position(llC).icon(bdC)
                .perspective(false).anchor(0.5f, 0.5f).rotate(30f).zIndex(7)
        if (animationBox!!.isChecked) {
            // 生长动画
            ooC.animateType(MarkerOptions.MarkerAnimateType.grow)
        }
        mMarkerC = mBaiduMap!!.addOverlay(ooC) as Marker
        val giflist = ArrayList<BitmapDescriptor>()
        giflist.add(bdA)
        giflist.add(bdB)
        giflist.add(bdC)
        val ooD = MarkerOptions().position(llD).icons(giflist)
                .zIndex(0).period(10)
        if (animationBox!!.isChecked) {
            // 生长动画
            ooD.animateType(MarkerOptions.MarkerAnimateType.grow)
        }
        mMarkerD = mBaiduMap!!.addOverlay(ooD) as Marker

        // add ground overlay
        val southwest = LatLng(39.92235, 116.380338)
        val northeast = LatLng(39.947246, 116.414977)
        val bounds = LatLngBounds.Builder().include(northeast)
                .include(southwest).build()

        val ooGround = GroundOverlayOptions()
                .positionFromBounds(bounds).image(bdGround).transparency(0.8f)
        mBaiduMap!!.addOverlay(ooGround)

        val u = MapStatusUpdateFactory
                .newLatLng(bounds.center)
        mBaiduMap!!.setMapStatus(u)

        mBaiduMap!!.setOnMarkerDragListener(object : BaiduMap.OnMarkerDragListener {
            override fun onMarkerDrag(marker: Marker) {}

            override fun onMarkerDragEnd(marker: Marker) {
                Toast.makeText(
                        this@MapScenicsActivity,
                        "拖拽结束，新位置：" + marker.position.latitude + ", "
                                + marker.position.longitude,
                        Toast.LENGTH_LONG).show()
            }

            override fun onMarkerDragStart(marker: Marker) {}
        })
    }

    /**
     * 清除所有Overlay
     *
     * @param view
     */
    fun clearOverlay(view: View?) {
        mBaiduMap!!.clear()
        mMarkerA = null
        mMarkerB = null
        mMarkerC = null
        mMarkerD = null
    }

    /**
     * 重新添加Overlay
     *
     * @param view
     */
    fun resetOverlay(view: View) {
        clearOverlay(null)
        initOverlay()
    }

    private inner class SeekBarListener : SeekBar.OnSeekBarChangeListener {

        override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                       fromUser: Boolean) {
            // TODO Auto-generated method stub
            val alpha = (seekBar.progress.toFloat()) / 10
            if (mMarkerA != null) {
                mMarkerA!!.alpha = alpha
            }
            if (mMarkerB != null) {
                mMarkerB!!.alpha = alpha
            }
            if (mMarkerC != null) {
                mMarkerC!!.alpha = alpha
            }
            if (mMarkerD != null) {
                mMarkerD!!.alpha = alpha
            }
        }

        override fun onStartTrackingTouch(seekBar: SeekBar) {
            // TODO Auto-generated method stub
        }

        override fun onStopTrackingTouch(seekBar: SeekBar) {
            // TODO Auto-generated method stub
        }

    }

    override fun onPause() {
        // MapView的生命周期与Activity同步，当activity挂起时需调用MapView.onPause()
        mMapView!!.onPause()
        super.onPause()
    }

    override fun onResume() {
        // MapView的生命周期与Activity同步，当activity恢复时需调用MapView.onResume()
        mMapView!!.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        // MapView的生命周期与Activity同步，当activity销毁时需调用MapView.destroy()
        mMapView!!.onDestroy()
        super.onDestroy()
        // 回收 bitmap 资源
        bdA.recycle()
        bdB.recycle()
        bdC.recycle()
        bdD.recycle()
        bd.recycle()
        bdGround.recycle()
    }
}