package com.hanifkf12.myrecyclerapp1.util

import android.content.Context

class MySharedPref(context: Context) {
    private val sharedPref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
    var name : String?
        get() {
            return sharedPref.getString(NAME_KEY,null)
        }
        set(value) {
            sharedPref.edit().putString(NAME_KEY,value).apply()
        }

    var login: Boolean
        get() {
            return sharedPref.getBoolean(LOGIN,false)
        }
        set(value) {
            sharedPref.edit().apply {
                putBoolean(LOGIN,value)
            }.apply()
        }

    fun clearPref() {
        sharedPref.edit().clear().apply()
    }
    companion object {
        private const val  NAME_KEY = "name"
        private const val  LOGIN = "login"
    }
}