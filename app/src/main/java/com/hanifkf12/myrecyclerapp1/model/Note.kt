package com.hanifkf12.myrecyclerapp1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        val id : Int?,

        @ColumnInfo(name = "title")
        val title: String,

        @ColumnInfo(name = "content")
        val content: String
)
