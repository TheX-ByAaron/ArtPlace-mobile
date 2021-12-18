package com.aaronx.artplace.ui.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aaronx.artplace.ui.theme.ViewShape
import com.aaronx.artplace.ui.theme.windowBackground


@Preview(showBackground = true, showSystemUi = false)
@Composable
fun SettingsFragment(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = MaterialTheme.colors.windowBackground, shape = MaterialTheme.shapes.ViewShape)
        , contentAlignment = Alignment.Center){

        Text("Settings fragment")
    }

}