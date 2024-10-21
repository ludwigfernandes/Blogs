package com.example.blogs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter


@Composable
fun ArticlesDetail(navController: NavHostController, viewModel: HomeViewModel) {
    val selectedArticle = viewModel.selectedArticle.value


    if (selectedArticle != null) {
        Column () {
            Text(
                text = selectedArticle.title?.rendered ?: "Unknown Agent",
                modifier = Modifier.padding(8.dp)
            )

            Image(
                painter = rememberAsyncImagePainter(model = selectedArticle.jetpackFeaturedMediaUrl),
                contentDescription = "Agent Image",
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }
    }
}
