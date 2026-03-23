package com.practicum.films.domain.api

import com.practicum.films.domain.models.FilmDescription

interface SearchFilmsDescriptionInteractor {
    fun searchFilmsDescription(expression: String, consumer: FilmConsumer)

    interface FilmConsumer {
        fun consume(result: List<FilmDescription>?, errorMessage: String?)

    }
}