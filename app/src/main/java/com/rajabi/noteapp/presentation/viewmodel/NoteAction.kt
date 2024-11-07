package com.rajabi.noteapp.presentation.viewmodel

import com.rajabi.noteapp.data.model.Note

sealed interface NoteAction {
    data class SaveNote(val note: Note) : NoteAction
    data class DeleteNote(val note: Note) : NoteAction
}