package com.rajabi.noteapp.presentation.compose.widgets

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean
) {
    Button(
        onClick = { onClick.invoke() },
        enabled = enabled,
        shape = CircleShape,
        modifier = modifier
    ) {
        Text(text = text)

    }
}