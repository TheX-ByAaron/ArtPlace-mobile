package com.aaronx.artplace.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(10.dp),
    large = RoundedCornerShape(15.dp)
)

val Shapes.ViewShape : Shape
    get() = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp, bottomEnd = 0.dp, bottomStart = 0.dp)