package com.example.littlelemon.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.littlelemon.ui.theme.LittleLemonColor




@RequiresApi(Build.VERSION_CODES.O)
// Set up Typography with custom colors and styles
val Typography = Typography(
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        color = LittleLemonColor.charcoal
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        color = LittleLemonColor.green
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = LittleLemonColor.charcoal
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        color = LittleLemonColor.cloud
    ),
    button = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = LittleLemonColor.yellow
    )
)

