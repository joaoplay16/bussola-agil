package com.playlab.bussolaagil.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun DialogAlert(text: String) {

    var showDialog by remember {
        mutableStateOf(true)
    }
    if (showDialog) {
        Dialog(
            onDismissRequest = { showDialog = false },
        ) {
            Card(
                backgroundColor = MaterialTheme.colors.surface,
                elevation = 4.dp
            ) {
                Text(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 10.dp,
                        bottom = 10.dp
                    ),
                    text = text,
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}