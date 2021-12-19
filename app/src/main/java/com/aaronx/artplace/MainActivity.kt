package com.aaronx.artplace

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aaronx.artplace.ui.composables.BottomBar
import com.aaronx.artplace.ui.composables.NavRoute
import com.aaronx.artplace.ui.composables.TopBar
import com.aaronx.artplace.ui.fragments.addpost.AddPostFragment
import com.aaronx.artplace.ui.fragments.home.CommentsFragment
import com.aaronx.artplace.ui.fragments.home.HomeFragment
import com.aaronx.artplace.ui.fragments.messages.ConversationFragment
import com.aaronx.artplace.ui.fragments.messages.MessagesFragment
import com.aaronx.artplace.ui.fragments.messages.PeopleFragment
import com.aaronx.artplace.ui.fragments.notifications.NotificationFragment
import com.aaronx.artplace.ui.fragments.profile.FavoritesFragment
import com.aaronx.artplace.ui.fragments.profile.ProfileFragment
import com.aaronx.artplace.ui.fragments.settings.SettingsFragment
import com.aaronx.artplace.ui.theme.ArtPlaceTheme
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

                            composable("Home"){  HomeFragment(navController)  }
                            composable("Notifications"){  NotificationFragment() }
                            composable("Messages"){ MessagesFragment(navController)  }
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

@Preview(showBackground = true, showSystemUi = false, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun DefaultPreview() {

}