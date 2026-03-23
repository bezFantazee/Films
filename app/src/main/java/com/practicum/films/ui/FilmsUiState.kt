package com.practicum.films.ui

import com.practicum.films.domain.models.FilmDescription

sealed interface FilmsUiState {
    object Initial: FilmsUiState
    object Loading: FilmsUiState

    data class Content(
        val filmsDescription: List<FilmDescription>
    ) : FilmsUiState

    data class Error(
        val errorMessage: String
    ) : FilmsUiState

    data class Empty(
        val message: String
    ) : FilmsUiState
}