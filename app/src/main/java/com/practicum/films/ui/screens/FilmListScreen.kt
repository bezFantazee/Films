package com.practicum.films.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.practicum.films.R
import com.practicum.films.domain.models.FilmDescription
import com.practicum.films.presenter.FilmsViewModel
import com.practicum.films.ui.FilmsUiEvent
import com.practicum.films.ui.FilmsUiState
import com.practicum.films.ui.NavRoutes
import com.practicum.films.ui.components.EditFilmField
import com.practicum.films.ui.components.EmptyScreen
import com.practicum.films.ui.components.ErrorScreen
import com.practicum.films.ui.components.FilmList
import com.practicum.films.ui.components.LoadingScreen
import com.practicum.films.ui.theme.FilmsThemeValues
import org.koin.androidx.compose.koinViewModel

@Composable
fun FilmListScreen(navController: NavController, innerPadding: PaddingValues) {
    val viewModel: FilmsViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is FilmsUiEvent.ShowToast -> {
                    Toast
                        .makeText(
                            context,
                            event.message,
                            Toast.LENGTH_LONG
                        )
                        .show()
                }
            }
        }
    }

    val focusManager = LocalFocusManager.current
    var text by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                focusManager.clearFocus()
            }
    ) {
        EditFilmField(
            label = R.string.film_search_label,
            value = text,
            onValueChange = {
                text = it
                if (text.equals("")) {
                    viewModel.clearSearch()
                }
                viewModel.searchDebounce(text)
            },
            onValueDelete = {
                text = ""
                viewModel.clearSearch()
                focusManager.clearFocus()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        when (state) {
            FilmsUiState.Initial -> {}
            FilmsUiState.Loading -> {
                LoadingScreen(
                    modifier = Modifier
                        .padding(top = 192.dp)
                )
            }
            is FilmsUiState.Content -> {
                FilmList(
                    navController = navController,
                    films = (state as FilmsUiState.Content).filmsDescription,
                    //films = films,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 12.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
            is FilmsUiState.Error -> {
                ErrorScreen(
                    message = (state as FilmsUiState.Error).errorMessage,
                    modifier = Modifier
                        .padding(top = 192.dp)
                )
            }
            is FilmsUiState.Empty -> {
                EmptyScreen(
                    message = (state as FilmsUiState.Empty).message,
                    modifier = Modifier
                        .padding(top = 192.dp)
                )
            }
        }

    }
}
