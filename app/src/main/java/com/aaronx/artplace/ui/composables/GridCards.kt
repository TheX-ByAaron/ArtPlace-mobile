package com.aaronx.artplace.ui.composables

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.aaronx.artplace.R
import com.aaronx.artplace.ui.theme.ArtPlaceTheme
import com.aaronx.artplace.ui.theme.OceanBlue500
import com.aaronx.artplace.ui.theme.SurfaceColor


@Composable
fun PostCard(){
    val imagePainter = rememberImagePainter(data = R.drawable.profile)
    Box(modifier = Modifier
        .padding(all = 4.dp)
        .fillMaxWidth()
        .fillMaxHeight()
        .aspectRatio(1F)
        .background(
            color = MaterialTheme.colors.background, shape = MaterialTheme.shapes.medium
        )) {

        Image(painter = imagePainter
            , contentDescription = "Post image"
            , modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .fillMaxHeight()
                .fillMaxWidth())

    }
}

@Composable
fun NotificationCard(){
    val imagePainter = rememberImagePainter(data = R.drawable.profile)
    val isExpanded = rememberSaveable{ mutableStateOf(false)}

    Row(modifier = Modifier
        .padding(top = 8.dp, bottom = 8.dp)
        .fillMaxWidth()
        .wrapContentHeight()
        .clip(shape = MaterialTheme.shapes.large)
        .background(color = MaterialTheme.colors.SurfaceColor)
        .clickable { isExpanded.value = !isExpanded.value }
        .animateContentSize()
        , verticalAlignment = Alignment.Top){

        Image(painter = imagePainter
                , contentDescription = "notification cover"
                , modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape))

        Column {

            Text(text = "Profile name"
                , fontSize = 16.sp
                , fontWeight = FontWeight.Bold
                , modifier = Modifier.padding(end = 8.dp,top = 8.dp))

            Text(text = "This is a notification from a member of the art place" +
                    ", let's see a longer one how much it takes to place a larger " +
                    "bla bla bla bla bla bla bla text here and over there."
                , fontSize = 14.sp
                , fontWeight = FontWeight.Normal
                , maxLines = if(!isExpanded.value) 1 else Int.MAX_VALUE
                , overflow = if(!isExpanded.value) TextOverflow.Ellipsis else TextOverflow.Visible
                , modifier = Modifier.padding(end = 8.dp))

            Text(text = "5d"
                , fontSize = 12.sp
                , fontWeight = FontWeight.Light
                , color = OceanBlue500
                , modifier = Modifier.padding(end = 8.dp, bottom = 8.dp))

        }


    }
}

@Composable
fun FeedCard(){

}

@Preview
@Composable
fun PreviewPostCard(){
    ArtPlaceTheme {
        FeedCard()
    }
}