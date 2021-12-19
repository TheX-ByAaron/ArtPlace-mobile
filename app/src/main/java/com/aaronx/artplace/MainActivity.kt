package com.aaronx.artplace

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aaronx.artplace.ui.composables.BottomBar
import com.aaronx.artplace.ui.composables.IconButton
import com.aaronx.artplace.ui.composables.NavRoute
import com.aaronx.artplace.ui.fragments.*
import com.aaronx.artplace.ui.theme.ArtPlaceTheme
import com.aaronx.artplace.ui.theme.IconColor
import com.aaronx.artplace.ui.theme.ViewShape
import com.aaronx.artplace.ui.theme.windowBackground

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent()
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainActivityContent(){
    val navController = rememberNavController()
    val currentBackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackEntry.value?.destination?.route

    val routes = arrayListOf(NavRoute(R.drawable.ic_home, "Home")
        , NavRoute(R.drawable.ic_bell, "Notifications")
        , NavRoute(R.drawable.ic_dms, "Messages")
        , NavRoute(R.drawable.ic_heart, "Favorites")
    )
    
    ArtPlaceTheme {
        Surface(color = MaterialTheme.colors.background ) {
            Scaffold(
                    topBar = {
                        AnimatedVisibility(currentRoute != "Comments"
                                && currentRoute != "Conversation") {

                            TopBar(navController)
                        }

                    },

                    content = {
                        NavHost(navController = navController
                            , startDestination = "Home"
                            , modifier = Modifier.background(
                              color = MaterialTheme.colors.windowBackground,
                              shape = MaterialTheme.shapes.ViewShape)){

                            composable("Home"){  HomeFragment()  }
                            composable("Notifications"){  NotificationFragment() }
                            composable("Messages"){ MessagesFragment()  }
                            composable("Favorites"){  FavoritesFragment()  }
                            composable("Profile"){  ProfileFragment()  }
                            composable("Comments"){ CommentsFragment() }
                            composable("Settings"){ SettingsFragment() }
                            composable("People"){ PeopleFragment() }
                            composable("AddPost"){ AddPostFragment() }
                            composable("Conversation"){ ConversationFragment() }

                        }
                    },

                    bottomBar = {
                        AnimatedVisibility(currentRoute != "Comments"
                                && currentRoute != "Conversation"
                                && currentRoute != "Settings"
                                && currentRoute != "AddPost"){

                            BottomBar(navController,routes,"Profile")

                        }

                    }
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TopBar(navController: NavController){

    val currentBackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackEntry.value?.destination?.route

    Row(modifier = Modifier
        .padding(start = 8.dp, end = 8.dp)
        .fillMaxWidth()
        .height(56.dp)
        ,horizontalArrangement = Arrangement.SpaceBetween
        , verticalAlignment = Alignment.CenterVertically){

        Image(painter = painterResource(id = R.drawable.ic_logo_text)
            , colorFilter = ColorFilter.tint(MaterialTheme.colors.IconColor)
            , modifier = Modifier
                .padding(start = 8.dp)
                .width(120.dp)
            , alignment = Alignment.CenterStart
            , contentDescription = "Application title")

        Row(horizontalArrangement = Arrangement.End){
            AnimatedVisibility(currentRoute == "Home") {
                IconButton(modifier = Modifier
                    .padding(start = 4.dp)
                    .size(45.dp),R.drawable.ic_add_post
                    , onClick = {navController.navigateTo("AddPost")})
            }

            AnimatedVisibility(currentRoute == "Messages"){
                IconButton(modifier = Modifier
                    .padding(start = 4.dp)
                    .size(45.dp),R.drawable.ic_users
                    , onClick = {navController.navigateTo("People")})
            }

            AnimatedVisibility(currentRoute == "Profile"){
                IconButton(modifier = Modifier
                    .padding(start = 4.dp)
                    .size(45.dp),R.drawable.ic_setting
                    , onClick = {navController.navigateTo("Settings")})
            }

        }
    }
}


fun NavController.navigateTo(route: String){
    this.navigate(route){
        launchSingleTop = true
        restoreState = true
    }
}



@Preview(showBackground = true, showSystemUi = false, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun DefaultPreview() {

}