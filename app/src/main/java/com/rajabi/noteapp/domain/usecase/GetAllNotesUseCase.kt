package com.rajabi.noteapp.domain.usecase

import com.rajabi.noteapp.data.model.Note
import com.rajabi.noteapp.domain.repository.NoteRepository

class GetAllNotesUseCase(private val repository: NoteRepository) {
    suspend fun execute(): kotlinx.coroutines.flow.Flow<List<Note>> {
        return repository.getAllNotes()
    }
}