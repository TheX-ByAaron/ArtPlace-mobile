package com.aaronx.artplace

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aaronx.artplace.ui.composables.BottomBar
import com.aaronx.artplace.ui.composables.NavRoute
import com.aaronx.artplace.ui.fragments.*
import com.aaronx.artplace.ui.theme.ArtPlaceTheme
import com.aaronx.artplace.ui.theme.IconColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent()
        }
    }
}

@Composable
fun MainActivityContent(){
    val navController = rememberNavController()
    val routes = arrayListOf(NavRoute(R.drawable.ic_home, "Home")
        , NavRoute(R.drawable.ic_bell, "Notifications")
        , NavRoute(R.drawable.ic_messages, "Messages")
        , NavRoute(R.drawable.ic_setting, "Settings")
    )
    
    ArtPlaceTheme {
        Surface(color = MaterialTheme.colors.background ) {
            Scaffold(topBar = { TopBar()},

                    content = {
                              NavHost(navController = navController
                                  , startDestination = "Home"){
                                  composable("Home"){  HomeFragment()  }
                                  composable("Notifications"){  NotificationFragment() }
                                  composable("Messages"){ MessagesFragment()  }
                                  composable("Settings"){  SettingsFragment()  }
                                  composable("Profile"){  ProfileFragment()  }
                              }
                    },

                    bottomBar = {
                        BottomBar(navController,routes,"profile")
                    }
            )
        }
    }
}

@Composable
fun TopBar(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp)
        ,horizontalArrangement = Arrangement.Center
        , verticalAlignment = Alignment.CenterVertically){

        Image(painter = painterResource(id = R.drawable.ic_logo_text)
            , colorFilter = ColorFilter.tint(MaterialTheme.colors.IconColor)
            , modifier = Modifier.width(150.dp)
            , alignment = Alignment.Center
            , contentDescription = "Application title")
    }
}



@Preview(showBackground = true, showSystemUi = false, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun DefaultPreview() {
    MainActivityContent()
}