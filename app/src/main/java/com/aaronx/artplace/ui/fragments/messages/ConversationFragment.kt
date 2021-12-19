package com.aaronx.artplace.ui.fragments.messages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.aaronx.artplace.ui.composables.AdvancedTextField
import com.aaronx.artplace.ui.theme.ArtPlaceTheme
import com.aaronx.artplace.ui.theme.SurfaceColor

@Composable
fun ConversationFragment(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()){

        ConversationHeader()
        LazyColumn(modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.SurfaceColor
                , shape = MaterialTheme.shapes.large)
            .weight(1F)){

            items(20){index: Int ->
                if(index % 2 == 0){
                    ConversationMessage()
                }else{
                    ConversationMessage()
                }
            }
        }
        AdvancedTextField(text = "Message")

    }
}

@Composable
fun ConversationHeader(){
    val profilePainter = rememberImagePainter(data = R.drawable.profile)
    Row(modifier = Modifier
        .padding(all = 8.dp)
        .fillMaxWidth()
        .background(MaterialTheme.colors.SurfaceColor
            , shape = MaterialTheme.shapes.large)
        , verticalAlignment = Alignment.CenterVertically){

        Image(painter = profilePainter
            , contentDescription = "user profile image"
            , modifier = Modifier
                .padding(all = 8.dp)
                .size(30.dp)
                .clip(CircleShape))

        Column(modifier = Modifier.padding(start= 4.dp,top = 8.dp, bottom = 8.dp)) {
            Text(text = "Aaron nerox"
                , maxLines = 1
                , overflow = TextOverflow.Ellipsis
                , style = MaterialTheme.typography.body1
                , fontWeight = FontWeight.SemiBold
                , fontSize = 14.sp)

            Text(text = "Online now"
                , maxLines = 1
                , overflow = TextOverflow.Ellipsis
                , color = MaterialTheme.colors.primary
                , style = MaterialTheme.typography.caption
                , fontSize = 12.sp)
        }
    }
}

@Composable
fun ConversationMessage(){

}

@Preview
@Composable
fun ConversationPreview(){
    ArtPlaceTheme {
        ConversationHeader()
    }

}