package com.rajabi.noteapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rajabi.noteapp.data.model.Note
import com.rajabi.noteapp.data.db.converters.DateConverter
import com.rajabi.noteapp.data.db.converters.UUIDConverter
@TypeConverters(DateConverter::class, UUIDConverter::class)

@Database(entities = [Note::class] , version = 1)
abstract class NoteDataBase :RoomDatabase() {
 abstract fun getNoteDao(): NoteDao


}