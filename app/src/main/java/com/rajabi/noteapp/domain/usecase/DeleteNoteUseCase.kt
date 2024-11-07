package com.rajabi.noteapp.domain.usecase

import com.rajabi.noteapp.data.model.Note
import com.rajabi.noteapp.domain.repository.NoteRepository

class DeleteNoteUseCase(private val repository: NoteRepository) {
    suspend fun execute(note: Note) {
        repository.deleteNote(note)
    }
}