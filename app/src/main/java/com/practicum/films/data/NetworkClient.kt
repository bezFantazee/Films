package com.practicum.films.data

import com.practicum.films.data.dto.Response

interface NetworkClient {
    fun doRequest(dto: Any): Response
}