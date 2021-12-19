package com.aaronx.artplace.ui.fragments.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.aaronx.artplace.R
import com.aaronx.artplace.ui.composables.CButton
import com.aaronx.artplace.ui.composables.PostCard
import com.aaronx.artplace.ui.theme.*


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileFragment(){
    Column(modifier = Modifier.padding(bottom = 74.dp)
        .fillMaxWidth()
        .fillMaxHeight()){

        val profilePainter = rememberImagePainter(data = R.drawable.profile)

        Column(modifier = Modifier.wrapContentHeight()) {

            Row(modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, bottom = 8.dp, top = 16.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically ){

                Image(painter = profilePainter
                    , contentDescription = "Profile image"
                    , modifier = Modifier
                        .padding(start = 8.dp, end = 16.dp)
                        .size(90.dp)
                        .clip(CircleShape))

                Column(modifier = Modifier.padding(start = 8.dp)) {
                    Text(text = "Aaron Nerox"
                        ,style = MaterialTheme.typography.h5
                        ,fontWeight = FontWeight.ExtraBold)

                    Text(text = "Designer/Mobile developer"
                        , style = MaterialTheme.typography.body1
                        , modifier = Modifier.padding(bottom = 4.dp))

                    CButton(text = "Modify profile"
                        , modifier= Modifier
                            .wrapContentWidth()
                            .wrapContentHeight()
                            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp)
                        , margin = Modifier.padding(top = 4.dp, bottom = 4.dp,end = 4.dp))
                }
            }

            Text(text = "~ This will be a description of the profile and what he does " +
                    "also how can he do that, you know just fun stuff ~"
                , style = MaterialTheme.typography.body2
                , fontStyle = FontStyle.Italic
                , modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))

            Text(text = "Member since March 2019"
                , style = MaterialTheme.typography.caption
                , fontSize = 12.sp
                , color = OceanBlue500
                , modifier = Modifier.padding(start = 16.dp, end = 16.dp))

            Surface(modifier = Modifier
                .padding(all = 16.dp)
                .height(2.dp)
                .fillMaxWidth()
                .background(
                    MaterialTheme.colors.primaryVariant, shape = MaterialTheme.shapes.medium
                )){}

            LazyVerticalGrid(cells = GridCells.Adaptive(minSize = 110.dp)
                , modifier = Modifier.padding(start = 8.dp, end = 8.dp)){
                items(20){
                    PostCard()
                }
            }
        }
    }

}


@Preview(showBackground = true, showSystemUi = false)
@Composable
fun ProfilePreview(){
    ArtPlaceTheme {
        ProfileFragment()
    }
}