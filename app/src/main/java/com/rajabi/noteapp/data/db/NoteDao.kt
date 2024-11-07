package com.rajabi.noteapp.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.rajabi.noteapp.data.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface  NoteDao {

    @Query("SELECT * FROM nots_tbl")
    fun getNotes():Flow<List<Note>>

    @Query("SELECT * FROM nots_tbl WHERE id =:id")
    suspend fun getNoteById(id:String) : Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: Note)

    @Query("DELETE FROM nots_tbl")
    suspend fun deleteAllNotes()

    @Delete
    suspend fun deleteNote(note: Note)


}
