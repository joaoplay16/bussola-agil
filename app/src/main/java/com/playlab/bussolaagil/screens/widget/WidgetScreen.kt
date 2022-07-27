package com.playlab.bussolaagil.screens.widget

import android.content.SharedPreferences
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playlab.bussolaagil.CompassAnimation
import com.playlab.bussolaagil.CompassAnimationStyled

@Composable
fun WidgetScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box (Modifier.clickable {
            Log.d("CLICK", "clique")

        }){
            CompassAnimation()
        }

        Box (Modifier.clickable {

        }){
            CompassAnimationStyled(size = 250.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWidgetScreen() {
    WidgetScreen()
}