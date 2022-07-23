package com.playlab.bussolaagil.util

fun getDirectionsLabel(degrees: Int):String{
    return when (degrees) {
        in 338 .. 360, in 0 .. 22 -> "N"
        in 23 .. 67 -> "NE"
        in 68 .. 112 -> "L"
        in 113 .. 157 -> "SE"
        in 158 .. 202 -> "S"
        in 203 .. 247 -> "SO"
        in 248 .. 292 -> "O"
        in 293 .. 337 -> "NO"
        else -> ""
    }
}