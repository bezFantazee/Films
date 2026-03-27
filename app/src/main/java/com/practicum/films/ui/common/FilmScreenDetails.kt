package com.practicum.films.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FilmPoster(film: FilmDescription, modifier: Modifier = Modifier){
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
fun FilmDescription(film: FilmDescription, modifier: Modifier = Modifier){
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
        color = Color(0xFFDB888B),
        textAlign = TextAlign.Center,
    )
}

@Composable
fun EmptyPlaceholder(message: String, modifier: Modifier = Modifier){
    Text(
        modifier = modifier,
        text = message,
        fontSize = 28.sp,
        color = Color(0xFF5D6E7D),
        textAlign = TextAlign.Center,
    )
}