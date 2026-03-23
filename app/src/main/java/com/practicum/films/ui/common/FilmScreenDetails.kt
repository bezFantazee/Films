package com.practicum.films.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.practicum.films.R
import com.practicum.films.domain.models.FilmDescription
import com.practicum.films.ui.theme.FilmsThemeValues

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FilmPoster(film: FilmDescription, modifier: Modifier = Modifier.Companion){
    GlideImage(
        model = film.image,
        contentDescription = film.title,
        loading = placeholder(R.drawable.placeholder),
        failure = placeholder(R.drawable.placeholder),
        contentScale = ContentScale.Companion.Crop,
        modifier = modifier
    )
}

@Composable
fun FilmDescription(film: FilmDescription, modifier: Modifier = Modifier.Companion){
    Column(
        modifier = modifier
    ) {
        Text(
            text = film.title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Companion.Medium,
            modifier = Modifier.Companion
                .padding(bottom = 8.dp)
        )
        Text(
            text = film.description,
            textAlign = TextAlign.Companion.Justify,
            fontSize = 12.sp
        )
    }
}

@Composable
fun PlaceHolder(message: String, modifier: Modifier = Modifier){
    Text(
        modifier = modifier,
        text = message,
        fontSize = 32.sp,
        color = FilmsThemeValues.colors.tertiary,
        textAlign = TextAlign.Center,
    )
}