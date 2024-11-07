package com.rajabi.noteapp.data.repository.datasourceimple

import com.rajabi.noteapp.data.db.NoteDao
import com.rajabi.noteapp.data.model.Note
import com.rajabi.noteapp.data.repository.datasource.NoteLocalDataSource
import kotlinx.coroutines.flow.Flow

class NoteLocalDataSourceImpl(private val noteDao: NoteDao) : NoteLocalDataSource {
    override suspend fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getNotes()
    }

    override suspend fun saveNote(note: Note) {
        noteDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }
}