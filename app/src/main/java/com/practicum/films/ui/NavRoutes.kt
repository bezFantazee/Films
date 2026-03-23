package com.practicum.films.ui

import kotlinx.serialization.Serializable

@Serializable
sealed class NavRoutes {
    @Serializable
    data object ListFilms: NavRoutes()

    @Serializable
    data class FilmDetailsScreen(
        val posterUrl: String,
        val title: String,
        val description: String
    ): NavRoutes()
}