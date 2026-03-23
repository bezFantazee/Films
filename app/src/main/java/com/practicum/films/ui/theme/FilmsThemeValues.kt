package com.practicum.films.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object FilmsThemeValues {
    val colors: ColorPalette
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
}