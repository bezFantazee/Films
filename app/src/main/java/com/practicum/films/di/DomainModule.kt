package com.practicum.films.di

import com.practicum.films.data.FilmRemoteRepositoryImpl
import com.practicum.films.domain.api.FilmRemoteRepository
import com.practicum.films.domain.api.SearchFilmsDescriptionInteractor
import com.practicum.films.domain.impl.SearchFilmsDescriptionInteractorImpl
import org.koin.dsl.module

val domainModule = module {
    single<FilmRemoteRepository> {
        FilmRemoteRepositoryImpl(get())
    }

    single<SearchFilmsDescriptionInteractor> {
        SearchFilmsDescriptionInteractorImpl(get())
    }
}