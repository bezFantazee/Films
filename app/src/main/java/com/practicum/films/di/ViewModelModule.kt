package com.practicum.films.di

import com.practicum.films.presenter.FilmsViewModel
import com.practicum.films.presenter.PosterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        FilmsViewModel(get(), get())
    }

    viewModel { (posterUrl: String) ->
        PosterViewModel(posterUrl)
    }
}