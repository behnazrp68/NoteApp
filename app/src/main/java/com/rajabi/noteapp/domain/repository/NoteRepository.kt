package com.rajabi.noteapp.domain.repository

import com.rajabi.noteapp.data.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn

interface NoteRepository {
    suspend fun addNote(note: Note)
    suspend fun deleteNote(note: Note)
    suspend fun getAllNotes(): Flow<List<Note>>

}