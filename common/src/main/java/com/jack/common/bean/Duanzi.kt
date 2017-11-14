package com.jack.common.bean

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import paperparcel.PaperParcel

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/16
 **/
@PaperParcel
data class Duanzi(
        override val id: String,
        @SerializedName("read_count") val readCount: String,
        @SerializedName("create_time") val createTime: String,
        @SerializedName("rid") val rid: String,
        @SerializedName("user_verified") val userVerified: String,
        @SerializedName("cell_type") val cellType: String,
        @SerializedName("user_id") val userId: String,
        @SerializedName("bury_count") val buryCount: String,//踩数量
        @SerializedName("title") val title: String,
        @SerializedName("ignore_web_transform") val ignoreWebTransform: String,
        @SerializedName("share_url") val shareUrl: String,
        @SerializedName("label") val label: String,
        @SerializedName("content") val content: String,
        @SerializedName("comment_count") val commentCount: String,//评论数量
        @SerializedName("group_flags") val groupFlags: String,
        @SerializedName("repin_count") val repinCount: String,//
        @SerializedName("digg_count") val diggCount: String,//赞数量
        @SerializedName("behot_time") val behotTime: String,
        @SerializedName("avatar_url") val avatarUrl: String,
        @SerializedName("group_id") val groupId: String
) : WithId, Parcelable {

    companion object {
        @JvmField
        val CREATOR = PaperParcelDuanzi.CREATOR
    }

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        PaperParcelDuanzi.writeToParcel(this, dest, flags)
    }

    override fun toString(): String {
        return "Duanzi(id='$id', readCount='$readCount', createTime='$createTime', rid='$rid', userVerified='$userVerified', cellType='$cellType', userId='$userId', buryCount='$buryCount', title='$title', ignoreWebTransform='$ignoreWebTransform', shareUrl='$shareUrl', label='$label', content='$content', commentCount='$commentCount', groupFlags='$groupFlags', repinCount='$repinCount', diggCount='$diggCount', behotTime='$behotTime', avatarUrl='$avatarUrl', groupId='$groupId')"
    }

}