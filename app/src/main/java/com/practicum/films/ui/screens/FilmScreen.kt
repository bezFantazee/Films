package com.practicum.films.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.practicum.films.R
import com.practicum.films.domain.models.FilmDescription
import com.practicum.films.presenter.FilmsViewModel
import com.practicum.films.ui.FilmsUiEvent
import com.practicum.films.ui.components.EditFilmField
import com.practicum.films.ui.components.FilmList
import com.practicum.films.ui.components.FilmTopBar
import com.practicum.films.ui.FilmsUiState
import com.practicum.films.ui.NavRoutes
import com.practicum.films.ui.components.EmptyScreen
import com.practicum.films.ui.components.ErrorScreen
import com.practicum.films.ui.components.LoadingScreen
import com.practicum.films.ui.theme.FilmsThemeValues
import org.koin.androidx.compose.koinViewModel

@Composable
fun FilmScreen(){
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val showBackButton = currentRoute != NavRoutes.ListFilms::class.qualifiedName

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = FilmsThemeValues.colors.backgroundVariant)
                    .statusBarsPadding()
                    .padding(4.dp)
            ){
                if(showBackButton){
                    IconButton(
                        onClick = {
                        navController.navigateUp()
                         },
                        modifier = Modifier
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Назад",
                            tint = FilmsThemeValues.colors.onPrimary,
                            modifier = Modifier
                                .size(32.dp)
                        )
                    }
                }
                FilmTopBar(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavRoutes.ListFilms,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colorStops = arrayOf(
                            0.5f to FilmsThemeValues.colors.backgroundVariant,
                            1f to FilmsThemeValues.colors.background
                        )
                    )
                )
                .padding(innerPadding)
            ) {
            composable<NavRoutes.ListFilms> {
                FilmListScreen(
                    navController = navController,
                    innerPadding
                )
            }

            composable<NavRoutes.FilmDetailsScreen> { navBackStackEntry ->
                val args = navBackStackEntry.toRoute<NavRoutes.FilmDetailsScreen>()
                FilmDetailsScreen(
                    navController = navController,
                    filmImage = args.posterUrl,
                    filmTitle = args.title,
                    filmDescription = args.description
                )
            }
        }
    }
}