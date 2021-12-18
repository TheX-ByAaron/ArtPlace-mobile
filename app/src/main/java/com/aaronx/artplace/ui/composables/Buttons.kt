package com.aaronx.artplace.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aaronx.artplace.R
import com.aaronx.artplace.ui.theme.ArtPlaceTheme
import com.aaronx.artplace.ui.theme.SurfaceColor
import com.airbnb.lottie.compose.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun CButton(modifier:Modifier = Modifier
            ,margin: Modifier = Modifier
            ,text:String
            ,onClick:() -> Unit = {}){

    Surface(modifier = margin
        .wrapContentHeight()
        .wrapContentWidth()
        .clickable { onClick.invoke() }

        , color = MaterialTheme.colors.primary
        , shape = MaterialTheme.shapes.small) {

        Box(modifier = modifier){
            Text(text = text
                , style = MaterialTheme.typography.button)
        }
    }

}

@Composable
fun AnimatedButton(modifier: Modifier = Modifier){

    //to Hoist later on
    val isLiked = rememberSaveable { mutableStateOf(false)}
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.like_animation))

    //to keep as an internal state
    val isPlaying = rememberSaveable{ mutableStateOf(false) }
    val pressed by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isPlaying.value,
        clipSpec = LottieClipSpec.Progress(0F, 0.5F),
        iterations = 1,
        restartOnPlay = true)
    val notPressed by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = true,
        clipSpec = LottieClipSpec.Progress(0F, 0.1F))

    LottieAnimation(
        composition = composition
        , progress = if(isLiked.value) pressed else notPressed
        , modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .clickable {
                isPlaying.value = !isPlaying.value
                isLiked.value = !isLiked.value
            })
}

@Composable
fun IconButton(modifier: Modifier = Modifier, icon: Int){

    Image(painter = painterResource(id = icon)
        , contentDescription = "icon button"
        , colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
        , modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .clickable { }
            .padding(all = 8.dp))

}

@Preview
@Composable
fun ButtonsPreview(){
    ArtPlaceTheme {
        IconButton(modifier = Modifier.size(45.dp), R.drawable.ic_messages)
    }

}