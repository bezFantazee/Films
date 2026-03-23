package com.practicum.films.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.practicum.films.presenter.FilmsViewModel
import com.practicum.films.ui.screens.FilmScreen
import com.practicum.films.ui.theme.FilmsTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun FilmApp(modifier: Modifier = Modifier) {
    FilmScreen()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FilmsTheme {
        FilmApp()
    }
}

@Preview(showBackground = true)
@Composable
fun FilmsDarkThemePreview(){
    FilmsTheme(darkTheme = true) {
        FilmApp()
    }
}
