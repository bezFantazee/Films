package com.practicum.films.domain.api

import com.practicum.films.domain.models.FilmDescription
import com.practicum.films.util.Resource

interface FilmRemoteRepository {
    fun search(expression: String): Resource<List<FilmDescription>>
}