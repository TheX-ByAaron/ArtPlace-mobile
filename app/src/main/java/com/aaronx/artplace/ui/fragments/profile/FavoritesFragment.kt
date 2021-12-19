package com.aaronx.artplace.ui.fragments.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aaronx.artplace.ui.composables.PostCard


@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true, showSystemUi = false)
@Composable
fun FavoritesFragment(){
    Box(modifier = Modifier.padding(bottom = 74.dp, top = 8.dp)
        .fillMaxWidth()
        .fillMaxHeight()){

        LazyVerticalGrid(cells = GridCells.Adaptive(minSize = 110.dp)
            , modifier = Modifier.padding(start = 8.dp, end = 8.dp)){
            items(20){
                PostCard()
            }
        }

    }

}