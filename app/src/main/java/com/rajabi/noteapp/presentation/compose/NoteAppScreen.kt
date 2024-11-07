package com.rajabi.noteapp.presentation.compose

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rajabi.noteapp.data.model.Note
import com.rajabi.noteapp.presentation.compose.widgets.NoteContent
import com.rajabi.noteapp.presentation.compose.widgets.NoteList
import com.rajabi.noteapp.presentation.compose.widgets.NoteTopBar
import com.rajabi.noteapp.presentation.viewmodel.NoteAction
import com.rajabi.noteapp.presentation.viewmodel.NoteState
import com.rajabi.noteapp.presentation.viewmodel.NoteViewModel

@Composable
fun NoteAppScreen(viewModel: NoteViewModel = hiltViewModel()) {
    val state by viewModel.noteState.collectAsState()
    NoteScreen(
        state = state,
        onAction = viewModel::onAction

    )
}


@Composable
fun NoteScreen(
    state: NoteState,
    onAction: (NoteAction) -> Unit

) {
    Log.d("NoteScreen", "Current state: $state")

    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    Column {
        NoteTopBar()
        NoteContent(
            title = title,
            description = description,
            onTitleChange = { title = it },
            onDescriptionChange = { description = it },
            onSaveClick = {
                if (title.isNotEmpty() && description.isNotEmpty()) {
                    onAction(NoteAction.SaveNote(Note(title = title, description = description)))
                    title = ""
                    description = ""
                    Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
                }
            }
        )
        HorizontalDivider(modifier = Modifier.padding(10.dp))
        NoteList(
            notes = state.allNoteState,
            onDeleteClick = { note -> onAction(NoteAction.DeleteNote(note)) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen(state = NoteState(allNoteState = emptyList(), isLoading = true)){}
}