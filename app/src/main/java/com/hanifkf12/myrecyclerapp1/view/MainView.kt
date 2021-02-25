package com.hanifkf12.myrecyclerapp1.view

import com.hanifkf12.myrecyclerapp1.model.Note

interface MainView {
    fun showData(data : List<Note>?)
    fun showLoading()
    fun hideLoading()
}