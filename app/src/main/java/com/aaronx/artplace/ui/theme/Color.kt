package com.aaronx.artplace.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val OceanBlue200 = Color(0x4D8BC2F2)
val OceanBlue500 = Color(0xFF8BC2F2)
val OceanBlue700 = Color(0xFF319AF6)

val Colors.SurfaceColor : Color
    get() = if(isLight)  Color(0xFFFFFFFF) else Color(0xFF222222)

val Colors.IconColor: Color
    get() = if(isLight) Color(0xFF222222) else Color(0xFFFFFFFF)
