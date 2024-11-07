package com.rajabi.noteapp.domain.usecase

import androidx.compose.runtime.referentialEqualityPolicy
import com.rajabi.noteapp.data.model.Note
import com.rajabi.noteapp.domain.repository.NoteRepository

class AddNoteUseCase(private val repository: NoteRepository) {
    suspend fun execute(note: Note) {
        repository.addNote(note)
    }
}