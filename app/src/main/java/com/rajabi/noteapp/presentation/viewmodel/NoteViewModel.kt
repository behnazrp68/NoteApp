package com.rajabi.noteapp.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rajabi.noteapp.data.model.Note
import com.rajabi.noteapp.domain.usecase.AddNoteUseCase
import com.rajabi.noteapp.domain.usecase.DeleteNoteUseCase
import com.rajabi.noteapp.domain.usecase.GetAllNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModel() {

    var noteState = MutableStateFlow(NoteState())
        private set

    init {
        getAllNotes()
    }


    fun onAction(action: NoteAction) {
        when (action) {
            is NoteAction.DeleteNote -> {
                removeNote(action.note)
            }

            is NoteAction.SaveNote -> {
                addNote(action.note)
            }
        }
    }

    private fun addNote(note: Note) =
        viewModelScope.launch {
            addNoteUseCase.execute(note)

        }

    private fun removeNote(note: Note) =
        viewModelScope.launch { deleteNoteUseCase.execute(note) }

    private fun getAllNotes() =
        viewModelScope.launch {
            getAllNotesUseCase.execute()
                .distinctUntilChanged()
                .collect { notes ->
                    Log.d("NoteViewModel", "Notes updated: $notes")
                    noteState.value =
                        noteState.value.copy(allNoteState = notes, isLoading = false)
                }
        }

}




