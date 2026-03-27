package com.practicum.films.ui.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoadingScreen(modifier: Modifier = Modifier){
    CircularProgressIndicator(
        modifier = modifier,
        color = Color(0xFF17191D),
        trackColor = Color(0xD8D4BCC8)
        )
}

@Composable
fun LoadingIndicator(modifier: Modifier = Modifier){
    CircularProgressIndicator(
        modifier = modifier,
        color = Color(0xFF5D6E7D),
        trackColor = Color(0xFFA5ACA5),
        strokeWidth = 6.dp
        )
}