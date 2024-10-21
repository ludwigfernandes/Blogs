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

@Composable
fun ArticlesHome(navController: NavHostController, viewModel: HomeViewModel) {
    val articles=viewModel.articles.value

    LaunchedEffect(Unit) {
        viewModel.fetchArticles()
    }

    if(articles!=null){
        LazyColumn {
            items(articles){ article ->
                ArticleItem(article!!, onClick = {
                    viewModel.selectArticle(article)
                    navController.navigate("detail")
                })
            }
        }
    }else {
        Text(text = "Loading...", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
    }
}

@Composable
fun ArticleItem(article: ArticlesItem, onClick: () -> Unit){
    Column(modifier = Modifier.padding(vertical = 8.dp).clickable { onClick() }) {
        Text(text = article.title?.rendered ?: "Unknown Agent", modifier = Modifier.padding(8.dp))

        Image(
            painter = rememberAsyncImagePainter(model = article.jetpackFeaturedMediaUrl),
            contentDescription = "Agent Image",
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}