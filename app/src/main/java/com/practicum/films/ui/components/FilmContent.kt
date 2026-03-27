package com.practicum.films.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.practicum.films.R
import com.practicum.films.domain.models.FilmDescription
import com.practicum.films.ui.NavRoutes
import com.practicum.films.ui.common.FilmPoster
import androidx.compose.ui.graphics.Color
import com.practicum.films.domain.models.filmsList
import com.practicum.films.ui.common.FilmDescription

@Composable
fun FilmTopBar(modifier: Modifier = Modifier){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ){
        Text(
            text = stringResource(R.string.app_name),
            fontSize = 36.sp,
            fontWeight = FontWeight.SemiBold,
            style = TextStyle(
                brush = Brush.verticalGradient(colorStops = arrayOf(
                    0.0f to Color(0xFF17191D),
                    0.4f to Color(0xFF17191D),
                    1f to Color(0xFFDB888B)
                ))
            )
        )
    }
}

@Composable
fun EditFilmField(
    @StringRes label: Int,
    value: String,
    onValueChange: (String) -> Unit,
    onValueDelete: () -> Unit,
    modifier: Modifier = Modifier){
    val focusManager = LocalFocusManager.current

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = stringResource(label),
                modifier = Modifier
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xFF5D6E7D),
            focusedContainerColor = Color(0xFF17191D),
            errorContainerColor = Color(0xFFDB888B),

            unfocusedTextColor = Color(0xFF17191D),
            focusedTextColor = Color(0xD8D4BCC8),

            unfocusedLabelColor = Color(0xD8D4BCC8),
            focusedLabelColor = Color(0xD8D4BCC8),

            unfocusedIndicatorColor = Color(0xFF17191D),
            focusedIndicatorColor = Color(0xD8D4BCC8),

            cursorColor = Color(0xFFA5ACA5)
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Поиск",
                tint = Color(0xD8D4BCC8)
            )
        },
        trailingIcon = {
            if(value.isNotEmpty()) {
                IconButton(
                    onClick = onValueDelete
                ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Очистить"
                    )
                }
            }
        },
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        modifier = modifier
    )
}

@Composable
fun FilmList(navController: NavController, films: List<FilmDescription>? = null, modifier: Modifier = Modifier){
    val filmsContent = films ?: filmsList
    LazyColumn(
        modifier = modifier
    ){
        items(filmsContent) { film ->
            FilmItem(
                film = film,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .wrapContentHeight()
                    .clickable{
                        navController.navigate(
                            NavRoutes.FilmDetailsScreen(
                                posterUrl = film.image,
                                title = film.title,
                                description = film.description
                            )
                        )
                    }
            )
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FilmItem(film: FilmDescription, modifier: Modifier = Modifier){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xD8D4BCC8),
            contentColor = Color(0xFF17191D)
        ),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
        ){
            FilmPoster(
                film = film,
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(2f / 3f)
                    .clip(RoundedCornerShape(4.dp))
            )
            FilmDescription(
                film = film,
                modifier = Modifier
                    .weight(3f)
                    .padding(start = 8.dp)
            )
        }
    }
}