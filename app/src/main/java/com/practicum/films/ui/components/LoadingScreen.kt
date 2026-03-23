package com.practicum.films.ui.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.practicum.films.ui.theme.FilmsThemeValues

@Composable
fun LoadingScreen(modifier: Modifier = Modifier){
    CircularProgressIndicator(
        modifier = modifier,
        color = FilmsThemeValues.colors.onPrimary,
        trackColor = FilmsThemeValues.colors.primary
        )
}