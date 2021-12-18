package com.aaronx.artplace.ui.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.compose.rememberImagePainter
import com.aaronx.artplace.R
import com.aaronx.artplace.ui.theme.IconColor
import com.aaronx.artplace.ui.theme.SurfaceColor

data class NavRoute(var icon: Int = 0,var Route:String)

@Composable
fun BottomBar(navController: NavController, Routes : ArrayList<NavRoute>, profileRoute: String){

    val isSelected = navController.currentBackStackEntryAsState()

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {

        Row(modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth()
            .height(60.dp)
            .background(
                color = MaterialTheme.colors.SurfaceColor, shape = MaterialTheme.shapes.medium
            )
            .padding(top = 5.dp, bottom = 5.dp)

            , verticalAlignment = Alignment.CenterVertically
            , horizontalArrangement = Arrangement.SpaceEvenly) {

            Routes.forEachIndexed { _, route ->
                Box(modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .clickable {
                        navController.navigate(route.Route) {
                            launchSingleTop = true
                            popUpTo("Home")
                            restoreState = true
                        }
                    }){
                    BottomBarItem(isSelected.value?.destination?.route == route.Route,route.icon)
                }
            }

            Box(modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .clickable {
                    navController.navigate(profileRoute) {
                        launchSingleTop = true
                        popUpTo("Home")
                        restoreState = true
                    }
                }){
                ProfileItem(isSelected = isSelected.value?.destination?.route == profileRoute)
            }



        }

    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BottomBarItem(isSelected: Boolean,
                  icon: Int){
    val selectedBarColor by animateColorAsState(targetValue = MaterialTheme.colors.primaryVariant)
    val itemSelectedColor by animateColorAsState(targetValue = MaterialTheme.colors.surface)

    Column(modifier= Modifier
        .requiredWidth(50.dp)
        .height(50.dp)
        .background(
            if (isSelected) itemSelectedColor else MaterialTheme.colors.SurfaceColor,
            shape = MaterialTheme.shapes.small
        )
        , horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = if(isSelected) Arrangement.SpaceBetween else Arrangement.Center){

        Image(modifier = Modifier
            .padding(all = 8.dp)
            .size(30.dp)
            , painter = painterResource(id = icon)
            , contentDescription = "Bottom bar item"
            , colorFilter = ColorFilter.tint(if(isSelected) selectedBarColor else MaterialTheme.colors.IconColor))

        AnimatedVisibility(visible = isSelected) {
            Surface(modifier = Modifier
                .height(5.dp)
                .width(35.dp)
                ,color = selectedBarColor
                , shape = MaterialTheme.shapes.medium){}
        }

    }
}

@Composable
fun ProfileItem(isSelected: Boolean){
    val selectedColor by animateColorAsState(targetValue = MaterialTheme.colors.primary)
    val profilePainter = rememberImagePainter(data = R.drawable.profile)

    Box(modifier= Modifier
        .height(50.dp)
        .requiredWidth(50.dp)
        , contentAlignment = Alignment.Center){

        Image(painter = profilePainter
            , contentDescription = "Profile icon"
            ,modifier = Modifier
                .size(35.dp)
                .clip(CircleShape)
                .border(
                    3.dp,
                    if (isSelected) selectedColor else MaterialTheme.colors.IconColor,
                    CircleShape
                ))
    }
}