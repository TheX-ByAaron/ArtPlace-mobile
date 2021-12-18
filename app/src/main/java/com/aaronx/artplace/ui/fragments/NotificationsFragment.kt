package com.aaronx.artplace.ui.fragments

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aaronx.artplace.ui.composables.NotificationCard
import com.aaronx.artplace.ui.theme.ArtPlaceTheme


@Composable
fun NotificationFragment(){
    Box(modifier = Modifier
        .padding(bottom = 74.dp)
        .fillMaxWidth()
        .fillMaxHeight()){

        LazyColumn(modifier = Modifier
            .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
            .fillMaxWidth()){

            item {
                Text(text = "Today"
                    ,style = MaterialTheme.typography.subtitle2
                    , fontWeight = FontWeight.Bold
                    , fontSize = 18.sp
                    , modifier = Modifier.padding(start = 4.dp, bottom = 4.dp))
            }

            items(10){
                NotificationCard()
            }

            item{
                Text(text = "Older"
                    , style = MaterialTheme.typography.subtitle2
                    , fontWeight = FontWeight.Bold
                    , fontSize = 18.sp
                    , modifier = Modifier.padding(start = 4.dp ,bottom = 4.dp, top = 8.dp))
            }

            items(15){
                NotificationCard()
            }

        }
    }

}

@Preview(showBackground = true, showSystemUi = false, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun NotificationFragmentPreview(){
    ArtPlaceTheme {
        NotificationFragment()
    }
}