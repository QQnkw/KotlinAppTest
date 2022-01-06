package com.kotlin.kotlinapp.bean

import android.util.Log

/**
 * 查看kotlin反编译java后的字段实现方式
 */
class TestField {
    val a = "1"
    var b = "2"
    lateinit var c: String

    /*------------------------------------------*/
    private val d = "4"
    private var e = "5"
    private lateinit var f: String

    /*------------------------------------------*/
    val g: String
        get() = "8"

    var h: String = "9"
        get() = "99"
        set(value) {
            field = "99"
        }

    /*------------------------------------------*/
    private val i: String
        get() = "10"

    private var j: String = "11"
        get() = "1111"
        set(value) {
            field = "1111"
        }

    /*------------------------------------------*/
    var k: String = "12"
        get() = "1212"
        private set(value) {
            field = "1212"
        }

    fun test() {
        c = "3"
        f = "6"
        Log.d("NKW", c + f)
    }

    /*------------------------------------------*/
    var l: String
        get() = "13"
        set(value) {
            value + "13"
        }

    var m: String
        get() = "14"
        private set(value) {
            value + "14"
        }

    private var n: String
        get() = "15"
        set(value) {
            value + "15"
        }
}