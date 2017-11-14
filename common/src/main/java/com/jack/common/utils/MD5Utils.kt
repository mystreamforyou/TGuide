package com.jack.common.utils

import java.io.File
import java.io.FileInputStream
import java.lang.*
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/10
 **/

object MD5Utils {
    fun getFileMD5(file: File): String? {
        if (!file.isFile) {
            return null
        }
        var digest: MessageDigest? = null
        var inStream: FileInputStream? = null
        val buffer = ByteArray(1024)
        var len: Int
        try {
            digest = MessageDigest.getInstance("MD5")
            inStream = FileInputStream(file)
            len = inStream.read(buffer, 0, 1024)
            while (len != -1) {
                digest!!.update(buffer, 0, len)
            }
            inStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

        val bigInt = BigInteger(1, digest!!.digest())
        return bigInt.toString(16)
    }

    fun getDirMD5(file: File, listChild: Boolean): Map<String, String>? {
        if (!file.isDirectory) {
            return null
        }
        val map = HashMap<String, String>()
        var md5: String?
        val files = file.listFiles()
        for (i in files!!.indices) {
            val f = files[i]
            if (f.isDirectory && listChild) {
                map.putAll(getDirMD5(f, listChild)!!)
            } else {
                md5 = getFileMD5(f)
                if (md5 != null) {
                    map.put(f.path, md5)
                }
            }
        }
        return map
    }

    fun getMD5(bytes: ByteArray): String {
        var md5Str = ""
        try {
            val md5: MessageDigest

            md5 = MessageDigest.getInstance("MD5")

            val md5Bytes = md5.digest(bytes)
            val hexValue = StringBuffer()

            for (m in md5Bytes.indices) {
                val value = md5Bytes[m].toInt()
                if (value < 16)
                    hexValue.append("0")
                hexValue.append(Integer.toHexString(value))
            }
            md5Str = hexValue.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }

        return md5Str
    }

    fun digest(text: String): String {
        try {
            val b = MessageDigest.getInstance("md5").digest(text.toByteArray())
            var hs = ""
            var stmp = ""
            for (n in b.indices) {
                stmp = Integer.toHexString(b[n].toInt())
                if (stmp.length == 1) {
                    hs = hs + "0" + stmp
                } else {
                    hs = hs + stmp
                }
            }
            return hs.toUpperCase()
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException(e)
        }

    }

    fun getStringMD5_16(plainText: String): String {
        var md5 = getStringMD5_32(plainText)
        if (md5!!.length >= 24) {
            md5 = md5.substring(8, 24)
        }
        return md5
    }

    fun getStringMD5_32(plainText: String): String? {

        var md: MessageDigest? = null
        try {
            md = MessageDigest.getInstance("MD5")
            md!!.update(plainText.toByteArray())
        } catch (e: Exception) {

            return null
        }

        return encodeHex(md.digest())
    }

//    public static String stringToMd5(String s) {
//        byte[] value = s.getBytes();
//        try {
//            MessageDigest md = MessageDigest.getContext("MD5");
//            md.update(value);
//            byte[] temp = md.digest();
//            StringBuilder sb = latest StringBuilder();
//            for (byte b : temp) {
//                sb.append(Integer.toHexString(b & 0xff));
//            }
//            String md5Version = sb.toString();
//
//
//            return md5Version;
//        } catch (NoSuchAlgorithmException e) {
//
//            e.printStackTrace();
//        }
//        return null;
//    }

    fun encodeHex(data: ByteArray?): String? {

        if (data == null) {

            return null
        }

        val HEXES = "0123456789abcdef"
        val len = data.size
        val hex = StringBuilder(len * 2)

        for (i in 0 until len) {

            hex.append(HEXES[(data[i].toInt()).ushr(4)])
            hex.append(HEXES[data[i].toInt()])
        }

        return hex.toString()
    }
}