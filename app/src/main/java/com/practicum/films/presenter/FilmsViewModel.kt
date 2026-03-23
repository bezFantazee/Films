package com.practicum.films.presenter

import com.practicum.films.R
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practicum.films.domain.api.SearchFilmsDescriptionInteractor
import com.practicum.films.domain.models.FilmDescription
import com.practicum.films.ui.FilmsUiEvent
import com.practicum.films.ui.FilmsUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import android.util.Log

class FilmsViewModel(
    private val context: Context,
    private val filmInteractor: SearchFilmsDescriptionInteractor
    ): ViewModel() {
    companion object {
        private const val SEARCH_DEBOUNCE_DELAY = 2000L
        private val SEARCH_REQUEST_TOKEN = Any()
    }
    private val handler = Handler(Looper.getMainLooper())
    private var latestSearchText: String? = null

    private val _state = MutableStateFlow<FilmsUiState>(FilmsUiState.Initial)
    val state: StateFlow<FilmsUiState> = _state

    private val _events = MutableSharedFlow<FilmsUiEvent>(
        replay = 0,
        extraBufferCapacity = 1
    )
    val events = _events.asSharedFlow()

    fun showToast(message: String) {
        viewModelScope.launch {
            _events.emit(FilmsUiEvent.ShowToast(message))
        }
    }

    fun clearSearch(){
        _state.value = FilmsUiState.Initial
        handler.removeCallbacksAndMessages(SEARCH_REQUEST_TOKEN)
    }

    fun searchDebounce(changedText: String) {
        if (latestSearchText == changedText) {
            return
        }
        this.latestSearchText = changedText

        handler.removeCallbacksAndMessages(SEARCH_REQUEST_TOKEN)

        val searchRunnable = Runnable {
            search(changedText)
        }

        val postTime = SystemClock.uptimeMillis() + SEARCH_DEBOUNCE_DELAY
        handler.postAtTime(
            searchRunnable,
            SEARCH_REQUEST_TOKEN,
            postTime
        )
    }
    fun search(newSearchText: String){

        if(newSearchText.isNotEmpty()){
            renderState(
                FilmsUiState.Loading
            )

            filmInteractor.searchFilmsDescription(
                newSearchText,
                object: SearchFilmsDescriptionInteractor.FilmConsumer{
                    override fun consume(result: List<FilmDescription>?, errorMessage: String?) {
                        handler.post {
                            val filmsDescription = mutableListOf<FilmDescription>()
                            if (result != null) {
                                filmsDescription.clear()
                                filmsDescription.addAll(result)
                            }
                            if (errorMessage != null) {
                                renderState(
                                    FilmsUiState.Error(
                                        errorMessage = context.getString(R.string.something_went_wrong)
                                    )
                                )
                                Log.d("13d", "error")
                                _events.tryEmit(FilmsUiEvent.ShowToast(errorMessage))
                            }
                            else if(filmsDescription.isEmpty()){
                                renderState(
                                    FilmsUiState.Empty(
                                        message = context.getString(R.string.nothing_found)
                                    )
                                )
                                Log.d("13d", "nothing")
                            } else {
                                renderState(
                                    FilmsUiState.Content(
                                        filmsDescription = filmsDescription
                                    )
                                )
                                Log.d("13d", "content")
                            }
                        }
                    }
                })
        }
    }

    private fun renderState(state: FilmsUiState){
        _state.value = state
    }

    override fun onCleared() {
        super.onCleared()
        handler.removeCallbacksAndMessages(SEARCH_REQUEST_TOKEN)
    }
}