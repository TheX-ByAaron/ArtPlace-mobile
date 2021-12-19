package com.aaronx.artplace.ui.fragments

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SettingsFragment(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        , contentAlignment = Alignment.Center){

        Text("Settings fragment ")

    }
}