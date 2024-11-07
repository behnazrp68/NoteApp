package com.rajabi.noteapp.data.repository.datasource

import com.rajabi.noteapp.data.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteLocalDataSource {

    suspend fun getAllNotes():Flow<List<Note>>
    suspend fun saveNote(note: Note)
    suspend fun deleteNote(note: Note)

}