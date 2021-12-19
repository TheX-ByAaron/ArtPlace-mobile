package com.aaronx.artplace.ui.fragments.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.aaronx.artplace.ui.composables.AdvancedTextField
import com.aaronx.artplace.ui.composables.CommentPostCard
import com.aaronx.artplace.ui.composables.FeedCard
import com.aaronx.artplace.ui.composables.PostCard
import com.aaronx.artplace.ui.theme.ArtPlaceTheme
import com.aaronx.artplace.ui.theme.OceanBlue200
import com.aaronx.artplace.ui.theme.SurfaceColor
import com.aaronx.artplace.ui.theme.windowBackground


@Composable
fun CommentsFragment(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        , verticalArrangement = Arrangement.Top
        , horizontalAlignment = Alignment.CenterHorizontally) {

        CommentPostCard()

        LazyColumn(
            Modifier
                .padding(start = 8.dp, end = 8.dp)
                .fillMaxWidth()
                .weight(1F)
                .background(
                    color = MaterialTheme.colors.SurfaceColor, shape = MaterialTheme.shapes.large
                )){

            items(20){

            }

        }

        AdvancedTextField()
    }
}

@Preview
@Composable
fun CommentsPreview(){
    ArtPlaceTheme {
        CommentsFragment()
    }
}