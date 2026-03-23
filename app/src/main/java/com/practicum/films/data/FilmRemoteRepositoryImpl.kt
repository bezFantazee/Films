package com.practicum.films.data


import android.util.Log
import com.practicum.films.data.dto.FilmRequest
import com.practicum.films.data.dto.FilmsResponse
import com.practicum.films.domain.api.FilmRemoteRepository
import com.practicum.films.domain.models.FilmDescription
import com.practicum.films.util.Resource

class FilmRemoteRepositoryImpl(private val networkClient: NetworkClient): FilmRemoteRepository {
    override fun search(expression: String): Resource<List<FilmDescription>> {
        val response = networkClient.doRequest(FilmRequest(expression))

        Log.d("13d", response.resultCode.toString())
        return when (response.resultCode) {
            -1 -> {
                Resource.Error("Проверьте подключение к интернету")
            }
            200 -> {
                Resource.Success((response as FilmsResponse).results.map {
                    Log.d("13d", it.title)
                    FilmDescription(it.title, it.image, it.description)
                })
            }
            else -> {
                Resource.Error("Ошибка сервера")
            }
        }
    }
}
