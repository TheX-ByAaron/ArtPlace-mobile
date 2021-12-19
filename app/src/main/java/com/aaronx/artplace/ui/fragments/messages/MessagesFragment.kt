package com.aaronx.artplace.ui.fragments.messages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aaronx.artplace.ui.composables.MessageCard
import com.aaronx.artplace.ui.theme.ArtPlaceTheme


@Composable
fun MessagesFragment(navController: NavController){
    Box(modifier = Modifier
        .padding(bottom = 74.dp, top = 8.dp)
        .fillMaxWidth()
        .fillMaxHeight()){

        LazyColumn{
            items(20){
                MessageCard {
                    navController.navigate("Conversation") {
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun MessagesFragmentPreview(){
    val navController = rememberNavController()
    ArtPlaceTheme {
        MessagesFragment(navController = navController)
    }
}