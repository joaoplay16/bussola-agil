package com.playlab.bussolaagil.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.playlab.bussolaagil.R

@Composable
fun getDirectionsLabel(degrees: Int):String{
    return when (degrees) {
        in 338 .. 360, in 0 .. 22 -> stringResource(R.string.north)
        in 23 .. 67 -> stringResource(R.string.northeast)
        in 68 .. 112 -> stringResource(R.string.east)
        in 113 .. 157 -> stringResource(R.string.southeast)
        in 158 .. 202 -> stringResource(R.string.south)
        in 203 .. 247 -> stringResource(R.string.southwest)
        in 248 .. 292 -> stringResource(R.string.west)
        in 293 .. 337 -> stringResource(R.string.northwest)
        else -> ""
    }
}
