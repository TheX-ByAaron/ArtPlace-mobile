package com.aaronx.artplace

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aaronx.artplace.ui.theme.ArtPlaceTheme

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
    ArtPlaceTheme {
        Surface(color = MaterialTheme.colors.background ) {
            Scaffold(topBar = { TopBar()},
                    content = {},
                    bottomBar = { BottomBar()})
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
            , colorFilter = ColorFilter.tint(MaterialTheme.colors.secondaryVariant)
            , modifier = Modifier.width(150.dp)
            , alignment = Alignment.Center
            , contentDescription = "Application title")
    }
}

@Composable
fun BottomBar(){
    var isSelected by remember{ mutableStateOf(0)}
    val iconList = arrayListOf(R.drawable.ic_home
        , R.drawable.ic_bell
        ,R.drawable.ic_messages
        ,R.drawable.ic_setting)

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {

        Row(modifier = Modifier
            .padding(all = 5.dp)
            .fillMaxWidth()
            .height(70.dp)
            .background(color = Color.White, shape = MaterialTheme.shapes.medium)
            .padding(top = 5.dp, bottom = 5.dp)
            , verticalAlignment = Alignment.CenterVertically
            , horizontalArrangement = Arrangement.SpaceEvenly) {

            for(position in 0..4){
                Box(modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .clickable { isSelected = position }){
                    BottomBarItem(isSelected == position)
                }
            }

        }

    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BottomBarItem(isSelected: Boolean){
    val selectedBarColor by animateColorAsState(targetValue = MaterialTheme.colors.primaryVariant)
    val itemSelectedColor by animateColorAsState(targetValue = MaterialTheme.colors.background)

    Column(modifier= Modifier
        .requiredWidth(60.dp)
        .height(60.dp)
        .background(
            if (isSelected) itemSelectedColor else Color.White, shape = MaterialTheme.shapes.small
        )
        , horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = if(isSelected) Arrangement.SpaceBetween else Arrangement.Center){

        Image(modifier = Modifier
            .padding(all = 8.dp)
            .size(30.dp)
            , painter = painterResource(id = R.drawable.ic_hand)
            , contentDescription = "Bottom bar item"
            , colorFilter = ColorFilter.tint(if(isSelected) selectedBarColor else Color.Black))

        AnimatedVisibility(visible = isSelected) {
            Surface(modifier = Modifier
                .height(5.dp)
                .width(40.dp)
                ,color = selectedBarColor
                , shape = MaterialTheme.shapes.medium){}
        }

    }
}



@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun DefaultPreview() {
    MainActivityContent()
}