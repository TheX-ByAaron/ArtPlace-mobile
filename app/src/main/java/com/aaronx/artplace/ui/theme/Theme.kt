package com.aaronx.artplace.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = OceanBlue200,
    primaryVariant = OceanBlue500,
    secondary = OceanBlue700,
    secondaryVariant = OceanBlue200,
    background = RoyalBlack,
)

private val LightColorPalette = lightColors(
    primary = OceanBlue500,
    primaryVariant = OceanBlue700,
    secondary = OceanBlue700,
    secondaryVariant = RoyalBlack,
    background = OceanBlue200,
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ArtPlaceTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}