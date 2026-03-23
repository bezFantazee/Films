package com.practicum.films.di

import com.practicum.films.data.NetworkClient
import com.practicum.films.data.network.FilmApi
import com.practicum.films.data.network.RetrofitNetworkClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single<FilmApi> {
        Retrofit.Builder()
            .baseUrl("https://tv-api.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FilmApi::class.java)
    }

    single<NetworkClient> {
        RetrofitNetworkClient(get(), get())
    }
}