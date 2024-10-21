package com.example.blogs

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.blogs.data.ArticlesItem
import org.apache.commons.text.StringEscapeUtils

@Composable
fun ArticlesHome(navController: NavHostController, viewModel: HomeViewModel) {
    val articles = viewModel.articles.value

    LaunchedEffect(Unit) {
        viewModel.fetchArticles()
    }

    if (articles != null) {
        LazyColumn(
            modifier = Modifier
                .padding(10.dp)
        ) {
            items(articles) { article ->
                ArticleItem(
                    article!!,
                    onClick = {
                        viewModel.selectArticle(article)
                        navController.navigate("detail")
                    },
                    viewModel = viewModel
                )
            }
        }
    } else {
        Text(text = "Loading...", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
    }
}

@Composable
fun ArticleItem(article: ArticlesItem, onClick: () -> Unit, viewModel: HomeViewModel) {
    Card(
        modifier = Modifier.padding(vertical = 5.dp),
        onClick = { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            val title = StringEscapeUtils.unescapeHtml4(article.title?.rendered ?: "Unknown")

            Image(
                painter = rememberAsyncImagePainter(model = article.jetpackFeaturedMediaUrl),
                contentDescription = "Agent Image",
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
            )
            Text(

                text = viewModel.cleanHTMLContent(article.title?.rendered),
                modifier = Modifier.padding(12.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}