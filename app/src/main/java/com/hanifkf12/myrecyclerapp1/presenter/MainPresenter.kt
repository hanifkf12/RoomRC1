package com.hanifkf12.myrecyclerapp1.presenter

import com.hanifkf12.myrecyclerapp1.model.Note

interface MainPresenter {
    fun addData(note: Note)
    fun removeData(index: Int)
    fun getData()
}