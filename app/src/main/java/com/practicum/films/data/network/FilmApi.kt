package com.practicum.films.data.network

import com.practicum.films.data.dto.FilmsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmApi {
    @GET("/en/API/SearchMovie/{token}/{expression}")
    fun getFilmsDescription(@Path("token") token: String, @Path("expression") expression: String): Call<FilmsResponse>
}