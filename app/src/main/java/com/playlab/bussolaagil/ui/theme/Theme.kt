package com.playlab.bussolaagil.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = BlueGray200,
    primaryVariant = BlueGray400,
    surface = DarkGrey900,
)

private val LightColorPalette = lightColors(
    primary = BlueGray200,
    primaryVariant = BlueGray400,
    onPrimary= Black800,
    background = Color.White,
    surface = LightBlue,

)

@Composable
fun BussolaAgilTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(colors.primaryVariant)

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}