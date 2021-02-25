package com.hanifkf12.myrecyclerapp1.db

import androidx.room.*
import com.hanifkf12.myrecyclerapp1.model.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addNote(note: Note) : Long

    @Query("SELECT * FROM notes")
    fun getNotes() : List<Note>?

    @Update
    fun updateNote(note: Note) : Int

    @Query("DELETE FROM notes WHERE id = :id")
    fun deleteNote(id: Int) : Int
}