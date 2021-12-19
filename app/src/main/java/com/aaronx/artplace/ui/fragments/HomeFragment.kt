package com.aaronx.artplace.ui.fragments

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aaronx.artplace.ui.composables.AddStory
import com.aaronx.artplace.ui.composables.FeedCard
import com.aaronx.artplace.ui.composables.StoryLayout
import com.aaronx.artplace.ui.theme.ArtPlaceTheme


@Composable
fun HomeFragment(navController: NavController){
    Box(modifier = Modifier
        .padding(bottom = 74.dp,top = 8.dp)
        .fillMaxWidth()
        .fillMaxHeight()){

        LazyColumn(modifier = Modifier.padding(start = 8.dp, end = 8.dp)){
            item{
                StoryRow()
            }

            items(30){
                FeedCard(navController)
            }

        }
    }

}

@Composable
fun StoryRow(){
    LazyRow{
        item{
            AddStory()
        }

        items(15){
            StoryLayout()
        }
    }
}

@Preview(showBackground = true, showSystemUi = false, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomePreview(){
    val navController = rememberNavController()
    ArtPlaceTheme {
        HomeFragment(navController)
    }
}