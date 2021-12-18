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


@Preview(showBackground = true, showSystemUi = false)
@Composable
fun HomeFragment(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight().background(color = MaterialTheme.colors.background)
        , contentAlignment = Alignment.Center){

        Text("Home fragment")
    }

}