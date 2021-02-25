package com.hanifkf12.myrecyclerapp1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hanifkf12.myrecyclerapp1.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {
    abstract fun noteDao() : NoteDao

    companion object{
        @Volatile
        private var INSTANCE : MyDatabase? = null
        fun getInstance(context: Context) : MyDatabase{
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    "my_note_ch6"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}