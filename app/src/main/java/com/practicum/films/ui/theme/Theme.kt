package com.practicum.films.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

val filmBaseLightPalette = ColorPalette(
    primary = Color(0xD8D4BCC8),
    secondary = Color(0xFF5D6E7D),
    tertiary = Color(0xFFDB888B),
    background = Color(0xFFB89C9B),
    backgroundVariant = Color(0xFFA5ACA5),
    onPrimary = Color(0xFF17191D),
    onSecondary = Color.White
)

val filmBaseDarkPalette = filmBaseLightPalette.copy(
    primary = Color(0xFF394A56),
    onPrimary = Color(0xFFD4BCC8),
    background = Color(0xFFB89C9B),
    backgroundVariant = Color(0xFF17191D),
)

val LocalColors = staticCompositionLocalOf<ColorPalette> {
    error("LocalColors is not provided")
}

@Composable
fun FilmsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (!darkTheme) filmBaseLightPalette
    else filmBaseDarkPalette

    CompositionLocalProvider(
        LocalColors provides colors,
        content = content
    )
}