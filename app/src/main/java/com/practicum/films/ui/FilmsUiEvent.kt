package com.practicum.films.ui

sealed interface FilmsUiEvent {
    data class ShowToast(val message: String) : FilmsUiEvent
}