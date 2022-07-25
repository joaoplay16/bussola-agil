package com.playlab.bussolaagil.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.playlab.bussolaagil.R

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.noto_sans_medium)),
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp
    ),
    h2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.pt_sans_caption_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    ),
    body1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.pt_sans_caption_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    )
)