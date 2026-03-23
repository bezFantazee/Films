package com.practicum.films.data.dto

import com.practicum.films.domain.models.FilmDescription


class FilmsResponse(
    val results: ArrayList<FilmDescription>,
    val errorMessage: String
): Response()