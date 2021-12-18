package com.aaronx.artplace.ui.fragments

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aaronx.artplace.ui.composables.MessageCard


@Preview(showBackground = true, showSystemUi = false)
@Composable
fun MessagesFragment(){
    Box(modifier = Modifier
        .padding(bottom = 74.dp, top = 8.dp)
        .fillMaxWidth()
        .fillMaxHeight()){

        LazyColumn{
            items(20){
                MessageCard()
            }
        }
    }

}