package com.aaronx.artplace.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.rememberImagePainter
import com.aaronx.artplace.R
import com.aaronx.artplace.ui.theme.ArtPlaceTheme
import com.aaronx.artplace.ui.theme.IconColor
import com.aaronx.artplace.ui.theme.OceanBlue200
import com.aaronx.artplace.ui.theme.SurfaceColor


@Composable
fun AddStory(){
    val picturePainter = rememberImagePainter(data = R.drawable.profile)

    Box(modifier = Modifier
        .padding(all = 8.dp)
        .size(65.dp)){

        Image(painter = painterResource(id = R.drawable.ic_plus)
            , contentDescription = "icon"
            , modifier = Modifier
                .size(25.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colors.SurfaceColor)
                .align(Alignment.BottomEnd)
                .zIndex(1F)
            , colorFilter = ColorFilter.tint(MaterialTheme.colors.IconColor))

        Box(modifier = Modifier
            .fillMaxSize()
            .border(2.dp, MaterialTheme.colors.IconColor, CircleShape)
            .zIndex(0F)){

            Image(painter = picturePainter
                , contentDescription = "Add story"
                , modifier = Modifier
                    .padding(6.dp)
                    .fillMaxSize()
                    .clip(CircleShape))
        }

    }

}

@Composable
fun StoryLayout(){
    val picturePainter = rememberImagePainter(data = R.drawable.profile)

    Box(modifier = Modifier
        .padding(all = 8.dp)
        .size(65.dp)
        .clip(CircleShape)
        .border(2.dp, MaterialTheme.colors.primary, CircleShape)){

        Image(painter = picturePainter
            , contentDescription = "Story picture"
            , modifier = Modifier
                .padding(6.dp)
                .fillMaxSize()
                .clip(CircleShape))
    }
}

@Preview
@Composable
fun StoryPreview(){
    ArtPlaceTheme {
        AddStory()
    }
}