package com.practicum.films.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.practicum.films.ui.common.PlaceHolder

@Composable
fun EmptyScreen(message: String, modifier: Modifier = Modifier){
    PlaceHolder(
        message = message,
        modifier = modifier
    )
}