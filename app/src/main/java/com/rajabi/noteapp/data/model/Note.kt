package com.rajabi.noteapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.rajabi.noteapp.data.db.converters.DateConverter
import java.time.Instant
import java.util.Date
import java.util.UUID

@Entity(tableName = "nots_tbl")
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "note_title")
    val title: String,

    @ColumnInfo(name = "note_description")
    val description: String,

    @TypeConverters(DateConverter::class)
    @ColumnInfo(name = "note_date")
    val dateTime: Date = Date.from(Instant.now())
) {
    constructor(title: String, description: String, dateTime: Date) : this(
        id = UUID.randomUUID(),
        title = title,
        description = description,
        dateTime = dateTime
    )
}