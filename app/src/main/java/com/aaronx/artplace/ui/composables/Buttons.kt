package com.aaronx.artplace.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aaronx.artplace.ui.theme.ArtPlaceTheme
import com.aaronx.artplace.ui.theme.SurfaceColor


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

@Preview(showSystemUi = true)
@Composable
fun ButtonsPreview(){
    ArtPlaceTheme {
        CButton(modifier= Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(start= 16.dp, end = 16.dp, top = 8.dp , bottom = 8.dp)
            ,text = "button")
    }

}