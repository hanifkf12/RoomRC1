package com.hanifkf12.myrecyclerapp1.presenter

import com.hanifkf12.myrecyclerapp1.db.MyDatabase
import com.hanifkf12.myrecyclerapp1.db.NoteDao
import com.hanifkf12.myrecyclerapp1.model.Note
import com.hanifkf12.myrecyclerapp1.view.MainView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainPresenterImp(private val view: MainView, private val noteDao: NoteDao) : MainPresenter {
    override fun addData(note: Note) {
        GlobalScope.launch {
            noteDao.addNote(note)
            getData()
        }

    }

    override fun removeData(index: Int) {
        GlobalScope.launch {
            noteDao.deleteNote(index)
            getData()
        }
    }

    override fun getData() {
        view.showLoading()
        GlobalScope.launch {
            val notes = noteDao.getNotes()
            view.showData(notes)
            view.hideLoading()
        }
    }

    override fun updateData(note: Note) {
        GlobalScope.launch {
            noteDao.updateNote(note)
            getData()
        }
    }

}