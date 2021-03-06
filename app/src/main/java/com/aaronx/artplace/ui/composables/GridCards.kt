package com.aaronx.artplace.ui.composables

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
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
fun FeedCard(navController: NavController){
    val imagePainter = rememberImagePainter(data = R.drawable.profile)
    val profilePainter = rememberImagePainter(data = R.drawable.profile)

    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .clip(shape = MaterialTheme.shapes.large)
        .background(color = MaterialTheme.colors.SurfaceColor)
        .animateContentSize()) {

        PostHeader(profilePainter)

        Image(painter = imagePainter
            , contentDescription = "post image"
            , contentScale = ContentScale.Fit
            , modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
                .defaultMinSize(minHeight = 100.dp)
                .clip(shape = MaterialTheme.shapes.medium))

        Row(modifier = Modifier
            .padding(bottom = 8.dp, start = 8.dp, end = 8.dp)
            .wrapContentHeight()){

            AnimatedButton(modifier = Modifier.size(45.dp))
            IconButton(modifier = Modifier
                .padding(start = 4.dp)
                .size(45.dp)
                , R.drawable.ic_messages
                ,onClick = {navController.navigateTo("Comments")})

        }

    }
}

@Composable
fun CommentPostCard(){
    val imagePainter = rememberImagePainter(data = R.drawable.profile)
    val profilePainter = rememberImagePainter(data = R.drawable.profile)

    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .clip(shape = MaterialTheme.shapes.large)
        .background(color = MaterialTheme.colors.SurfaceColor)
        .animateContentSize()) {

        PostHeader(profilePainter = profilePainter)

        Row(modifier = Modifier.fillMaxWidth()
            , verticalAlignment = Alignment.CenterVertically){

            Image(painter = imagePainter
                , contentDescription = "post image"
                , contentScale = ContentScale.Crop
                , modifier = Modifier
                    .padding(all = 8.dp)
                    .size(90.dp)
                    .clip(shape = MaterialTheme.shapes.medium))

            Column(modifier = Modifier.fillMaxWidth()) {

                Row(verticalAlignment = Alignment.CenterVertically){
                    AnimatedButton(modifier = Modifier.padding(end = 8.dp, start = 8.dp).size(45.dp))
                    Text(text = "150 K")
                }

                Row(verticalAlignment = Alignment.CenterVertically){
                    IconButton(icon = R.drawable.ic_messages
                        ,modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                        .size(45.dp))

                    Text(text = "120 K")
                }
            }
        }


    }
}

@Composable
fun PostHeader(profilePainter: Painter){
    Row(modifier = Modifier
        .padding(top = 8.dp, bottom = 4.dp, start = 8.dp, end = 8.dp)
        , verticalAlignment = Alignment.CenterVertically){

        Image(painter = profilePainter
            , contentDescription = "user profile image"
            , modifier = Modifier
                .padding(end = 8.dp)
                .size(30.dp)
                .clip(CircleShape))

        Column {
            Text(text = "Aaron nerox"
                , maxLines = 1
                , overflow = TextOverflow.Ellipsis
                , style = MaterialTheme.typography.body1
                , fontWeight = FontWeight.SemiBold
                , fontSize = 14.sp
                , modifier = Modifier.padding(bottom = 2.dp))

            Text(text = "The white house"
                , maxLines = 1
                , overflow = TextOverflow.Ellipsis
                , color = MaterialTheme.colors.primary
                , style = MaterialTheme.typography.caption
                , fontSize = 12.sp)
        }
    }
}

@Composable
fun MessageCard(onClick: () -> Unit = {}){
    val contactPainter = rememberImagePainter(data = R.drawable.profile)

    Row(modifier = Modifier
        .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
        .fillMaxWidth()
        .wrapContentHeight()
        .background(
            color = MaterialTheme.colors.SurfaceColor, shape = MaterialTheme.shapes.large
        )
        .clip(shape = MaterialTheme.shapes.large)
        .clickable { onClick.invoke() }
        , verticalAlignment = Alignment.CenterVertically){

        Box {
            Image(painter = contactPainter
                , contentDescription = "contact profile picture"
                , modifier = Modifier
                    .padding(all = 8.dp)
                    .size(45.dp)
                    .clip(CircleShape))

            Surface(modifier = Modifier
                .padding(all = 8.dp)
                .size(15.dp)
                .clip(CircleShape)
                .border(2.dp, color = MaterialTheme.colors.SurfaceColor, CircleShape)
                .align(Alignment.BottomEnd)
                , color = MaterialTheme.colors.primary) {}
        }

        Column {
            Text(text = "No name here"
                , fontSize = 16.sp
                , fontWeight = FontWeight.SemiBold
                , modifier = Modifier.padding(bottom = 4.dp, end = 8.dp)
                , maxLines = 1
                , overflow = TextOverflow.Ellipsis)

            Text(text = "This is the message content and i need it to be big"
                , fontSize = 14.sp
                , fontWeight = FontWeight.Normal
                , modifier = Modifier.padding(end = 8.dp)
                , maxLines = 1
                , overflow = TextOverflow.Ellipsis)
        }
    }
}

@Preview
@Composable
fun PreviewPostCard(){
    ArtPlaceTheme {
        CommentPostCard()
    }
}