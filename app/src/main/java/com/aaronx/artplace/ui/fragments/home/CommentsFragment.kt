package com.aaronx.artplace.ui.fragments.home

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
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
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.aaronx.artplace.R
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
                Column(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()) {

                    CommentComposable()
                    Surface(modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .height(1.dp)
                        , color = MaterialTheme.colors.primary) {}

                }
            }

        }

        AdvancedTextField()
    }
}

@Composable
fun CommentComposable(){
    val isExpanded = rememberSaveable { mutableStateOf(false)}
    val profilePainter = rememberImagePainter(data = R.drawable.profile)

    Row(modifier = Modifier
        .padding(top = 8.dp, bottom = 8.dp)
        .animateContentSize()
        .clip(MaterialTheme.shapes.medium)
        .clickable { isExpanded.value = !isExpanded.value }
        , verticalAlignment = Alignment.Top){

        Image(painter = profilePainter
            , contentDescription = "user profile image"
            , modifier = Modifier
                .padding(all = 8.dp)
                .size(30.dp)
                .clip(CircleShape))

        Column {
            Text(text = "Aaron nerox"
                , maxLines = 1
                , overflow = TextOverflow.Ellipsis
                , style = MaterialTheme.typography.body1
                , fontWeight = FontWeight.SemiBold
                , fontSize = 14.sp
                , modifier = Modifier.padding(bottom = 4.dp))

            Text(text = "This is a coment to see how a comment would go over here, just in the comment section"
                , maxLines = if(isExpanded.value) Int.MAX_VALUE else 5
                , overflow = if(isExpanded.value) TextOverflow.Visible else TextOverflow.Ellipsis
                , modifier = Modifier.padding(end = 4.dp)
                , style = MaterialTheme.typography.caption
                , fontSize = 14.sp)
        }
    }
}

@Preview
@Composable
fun CommentsPreview(){
    ArtPlaceTheme {
        CommentComposable()
    }
}