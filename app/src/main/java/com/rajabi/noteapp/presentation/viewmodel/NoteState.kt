package com.rajabi.noteapp.presentation.viewmodel

import com.rajabi.noteapp.data.model.Note
import kotlinx.coroutines.flow.Flow

data class NoteState(
    val allNoteState: List<Note> = emptyList(),
    val isSavedNoteClicked: Boolean = false,
    val isDeleteNoteClicked: Boolean = false,
    val isLoading: Boolean = false
)