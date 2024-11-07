package com.rajabi.noteapp.data.repository

import com.rajabi.noteapp.data.model.Note
import com.rajabi.noteapp.data.repository.datasource.NoteLocalDataSource
import com.rajabi.noteapp.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteLocalDataSource: NoteLocalDataSource
):NoteRepository {
    override suspend fun addNote(note: Note) = noteLocalDataSource.saveNote(note)
    override suspend fun deleteNote(note: Note) = noteLocalDataSource.deleteNote(note)
    override suspend fun getAllNotes():Flow<List<Note>> = noteLocalDataSource.getAllNotes()
        .flowOn(Dispatchers.IO).conflate()
}