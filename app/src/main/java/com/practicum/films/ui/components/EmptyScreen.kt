package com.practicum.films.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.practicum.films.ui.common.EmptyPlaceholder
import com.practicum.films.ui.common.PlaceHolder

@Composable
fun EmptyScreen(message: String, modifier: Modifier = Modifier){
    EmptyPlaceholder(
        message = message,
        modifier = modifier
    )
}