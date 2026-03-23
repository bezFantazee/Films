package com.practicum.films.domain.impl

import com.practicum.films.domain.api.FilmRemoteRepository
import com.practicum.films.domain.api.SearchFilmsDescriptionInteractor
import com.practicum.films.util.Resource
import java.util.concurrent.Executors

class SearchFilmsDescriptionInteractorImpl(private val repository: FilmRemoteRepository): SearchFilmsDescriptionInteractor {
    private val executor = Executors.newCachedThreadPool()

    override fun searchFilmsDescription(
        expression: String,
        consumer: SearchFilmsDescriptionInteractor.FilmConsumer
    ) {
        executor.execute {
            when(val resource = repository.search(expression)) {
                is Resource.Success -> { consumer.consume(resource.data, null)}
                is Resource.Error -> {consumer.consume(null, resource.message)}
            }
        }
    }
}