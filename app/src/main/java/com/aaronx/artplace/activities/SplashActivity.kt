package com.aaronx.artplace.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aaronx.artplace.R
import com.aaronx.artplace.ui.theme.ArtPlaceTheme
import com.aaronx.artplace.ui.theme.IconColor
import com.airbnb.lottie.compose.*

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen(this)
        }
    }
}

@Composable
fun SplashScreen(context: Context){
    ArtPlaceTheme {

        Surface(color = MaterialTheme.colors.background) {
            Box(modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                , contentAlignment = Alignment.BottomCenter){

                Column(verticalArrangement = Arrangement.SpaceEvenly) {

                    val composition by rememberLottieComposition(
                        spec = LottieCompositionSpec
                            .RawRes(R.raw.loading_animation))

                    val progress by animateLottieCompositionAsState(
                        composition = composition
                        , iterations = LottieConstants.IterateForever
                        , isPlaying = true
                        , restartOnPlay = true)

                    Image(painter = painterResource(id = R.drawable.ic_launcher_foreground)
                        , contentDescription = "App logo"
                        , modifier = Modifier.size(250.dp)
                        , colorFilter = ColorFilter.tint(MaterialTheme.colors.IconColor))

                    LottieAnimation(
                        composition = composition
                        , progress = progress
                        , modifier = Modifier.size(250.dp))

                }

            }
        }

        startTimer(context)
    }
}


fun startTimer(context: Context){
    Handler(Looper.getMainLooper())
        .postDelayed({
             context.startActivity(Intent(context, MainActivity::class.java))
        }, 2000)
}