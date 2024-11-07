package com.rajabi.noteapp.presentation.compose.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NoteContent(
    title: String,
    description: String,
    onTitleChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit,
    onSaveClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NoteInputText(
            text = title,
            label = "Title",
            onTextChange = {
                if (it.all { char -> char.isLetter() || char.isWhitespace() }) onTitleChange(it)
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        NoteInputText(
            modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
            text = description,
            label = "Add a Note",
            maxLine = 4,
            onTextChange = {
                if (it.all { char -> char.isLetter() || char.isWhitespace() }) onDescriptionChange(it)
            }
        )
        NoteButton(
            modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
            text = "Save",
            onClick = onSaveClick,
            enabled = title.isNotEmpty() && description.isNotEmpty()
        )
    }
}
