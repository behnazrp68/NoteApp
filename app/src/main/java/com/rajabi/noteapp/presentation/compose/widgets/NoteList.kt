package com.rajabi.noteapp.presentation.compose.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rajabi.noteapp.data.model.Note
import com.rajabi.noteapp.util.formatDate


@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onClick: (Note) -> Unit
) {
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
            .fillMaxWidth(),
        color = Color(0xFFC1ACC5),
        shadowElevation = 6.dp
    ) {
        Column(
            modifier = Modifier
                .padding(
                    horizontal = 14.dp,
                    vertical = 6.dp
                )
                .clickable {
                    onClick.invoke(note)
                },
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = note.title, style = MaterialTheme.typography.headlineLarge)
            Text(text = note.description, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = formatDate(note.dateTime.time),
                style = MaterialTheme.typography.titleSmall
            )

        }
    }
}
@Composable
fun NoteList(
    notes: List<Note>,
    onDeleteClick: (Note) -> Unit
) {
    LazyColumn {
        items(notes) { note ->
            NoteRow(note = note, onClick = { onDeleteClick(note) })
        }
    }
}

