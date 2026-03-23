package com.practicum.films.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

class PosterViewModel(posterUrl: String): ViewModel() {
    private val posterUrlLiveData = MutableLiveData<String>(posterUrl)
    fun observePosterUrl(): LiveData<String> = posterUrlLiveData

    companion object {
        fun getFactory(value: String): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                PosterViewModel(value)
            }
        }
    }
}