package com.example.blogs

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.blogs.data.ArticlesItem
import org.apache.commons.text.StringEscapeUtils

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ArticlesHome(navController: NavHostController, viewModel: HomeViewModel) {
    val isNetworkAvailable by viewModel.isNetworkAvailable.collectAsState()





    if (isNetworkAvailable) {
        val articles = viewModel.articles.value

        LaunchedEffect(Unit) {
            viewModel.fetchArticles()
        }

        if (articles != null) {

            LazyColumn(
                modifier = Modifier.padding(10.dp)
            ) {
                items(articles) { article ->
                    Log.d("TAG", article?.dateGmt!!)

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
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
                LottieAnimation(
                    modifier = Modifier.fillMaxWidth(),
                    composition = composition,
                    iterations = LottieConstants.IterateForever
                )
            }
        }
    }else{
        OfflineScreen()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ArticleItem(article: ArticlesItem, onClick: () -> Unit, viewModel: HomeViewModel) {
    Card(
        modifier = Modifier.padding(vertical = 6.dp),
        onClick = { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Image(
                painter = rememberAsyncImagePainter(model = article.jetpackFeaturedMediaUrl),
                contentDescription = "Agent Image",
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth,
            )
            Text(
                text = viewModel.cleanHTMLContent(article.title?.rendered),
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            Box(modifier = Modifier.fillMaxWidth()){
                Text(
                    text = viewModel.formatDate(article.dateGmt!!),
                    modifier = Modifier.padding(10.dp).align(Alignment.TopStart),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}