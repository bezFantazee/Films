package com.practicum.films.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.practicum.films.R
import com.practicum.films.ui.NavRoutes
import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.compose.Dimension

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FilmDetailsScreen(navController: NavController, filmImage: String, filmTitle: String, filmDescription: String) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        ConstraintLayout {
            val (image, title, description, titleText, descriptionText) = createRefs()

            val endBarrier = createEndBarrier(title, description)
            val bottomBarrier = createBottomBarrier(title, titleText)
            GlideImage(
                model = filmImage,
                contentDescription = filmTitle,
                loading = placeholder(R.drawable.placeholder),
                failure = placeholder(R.drawable.placeholder),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .aspectRatio(2f / 3f)
                    .clip(RoundedCornerShape(32.dp))
            )

            Text(
                text = "Название:",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Justify,
                color = Color(0xFF17191D),
                modifier = Modifier
                    .constrainAs(title) {
                        top.linkTo(image.bottom, margin = 32.dp)
                        start.linkTo(parent.start)
                    }
            )
            Text(
                text = "Описание:",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Justify,
                color = Color(0xFF17191D),
                modifier = Modifier
                    .constrainAs(description) {
                        top.linkTo(bottomBarrier, margin = 8.dp)
                        start.linkTo(parent.start)
                    }
            )

            Text(
                text = filmTitle,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                color = Color(0xFF17191D),
                modifier = Modifier
                    .constrainAs(titleText) {
                        top.linkTo(title.top)
                        start.linkTo(endBarrier, margin = 64.dp)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }
            )
            Text(
                text = filmDescription,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                color = Color(0xFF17191D),
                modifier = Modifier
                    .constrainAs(descriptionText) {
                        top.linkTo(description.top)
                        start.linkTo(endBarrier, margin = 64.dp)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }
            )
        }
    }
}
