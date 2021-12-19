package com.aaronx.artplace.ui.fragments.addpost

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.aaronx.artplace.ui.fragments.addpost.AddPostViewModel

@Composable
fun AddPostFragment(viewModel: AddPostViewModel = AddPostViewModel()){

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        , contentAlignment = Alignment.Center){

        Text("Add post fragment")

    }
}