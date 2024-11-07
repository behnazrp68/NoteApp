package com.rajabi.noteapp.presentation.compose.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rajabi.noteapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun NoteTopBar() {
    TopAppBar(title = {
        Text(stringResource(id = R.string.app_name),
        color = MaterialTheme.colorScheme.primary)
    }, actions = {
        Icon(
            imageVector = Icons.Rounded.Create,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(10.dp)
        )
    }
    )
}