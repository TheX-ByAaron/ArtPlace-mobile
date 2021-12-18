package com.aaronx.artplace.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.aaronx.artplace.R
import com.aaronx.artplace.ui.theme.ArtPlaceTheme


@Composable
fun PostCard(){
    val imagePainter = rememberImagePainter(data = R.drawable.profile)
    Box(modifier = Modifier
        .padding(all = 4.dp)
        .fillMaxWidth()
        .fillMaxHeight()
        .aspectRatio(1F)
        .background(
            color = MaterialTheme.colors.background, shape = MaterialTheme.shapes.medium)) {

        Image(painter = imagePainter
            , contentDescription = "Post image"
            , modifier = Modifier.clip(MaterialTheme.shapes.medium)
                .fillMaxHeight()
                .fillMaxWidth())

    }
}


@Preview
@Composable
fun PreviewPostCard(){
    ArtPlaceTheme {
        PostCard()
    }
}