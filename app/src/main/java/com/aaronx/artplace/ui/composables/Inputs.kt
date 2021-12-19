package com.aaronx.artplace.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aaronx.artplace.R
import com.aaronx.artplace.ui.theme.ArtPlaceTheme
import com.aaronx.artplace.ui.theme.SurfaceColor


@Composable
fun AdvancedTextField(text: String){
    var comment by remember{ mutableStateOf("")}

    Row(modifier = Modifier
        .padding(all = 8.dp)
        .fillMaxWidth()
        .height(60.dp)
        .clip(MaterialTheme.shapes.large)
        .background(color = MaterialTheme.colors.SurfaceColor)
        , verticalAlignment = Alignment.CenterVertically
        , horizontalArrangement = Arrangement.SpaceBetween){

        TextField(value = comment
            , onValueChange = { comment = it}
            , modifier = Modifier.weight(1F)
                .padding(start = 4.dp, end = 4.dp)
            ,shape = MaterialTheme.shapes.large
            , label = { Text(text)}
            , singleLine = true
            , maxLines = 1
            , colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.SurfaceColor,
                disabledIndicatorColor = MaterialTheme.colors.SurfaceColor,
                errorIndicatorColor = MaterialTheme.colors.SurfaceColor,
                focusedIndicatorColor = MaterialTheme.colors.SurfaceColor,
                unfocusedIndicatorColor = MaterialTheme.colors.SurfaceColor))

        IconButton(icon = R.drawable.ic_dms
            , modifier = Modifier
                .padding(8.dp)
                .requiredSize(45.dp)
            , onClick = {})
    }
}

@Preview
@Composable
fun AdvancedTextFieldPreview(){
    ArtPlaceTheme {
        AdvancedTextField("Add a comment")
    }
}