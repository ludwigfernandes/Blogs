package com.example.blogs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.blogs.data.ArticlesItem

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ArticlesHome(navController: NavHostController, viewModel: HomeViewModel) {

    //.collectAsState() is a Compose function that collects values from a Flow and converts it into a State object.
    //by help isNetworkAvailable to be assigned directly to the value of state from collectAsState, making it reactive
    val isNetworkAvailable by viewModel.isNetworkAvailable.collectAsState()

    val articles = viewModel.articles.value

    LaunchedEffect(Unit) {
        viewModel.fetchArticles()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (!isNetworkAvailable) {
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.no_network))
            Spacer(modifier = Modifier.height(10.dp))
            LottieAnimation(
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp),
                composition = composition,
                iterations = LottieConstants.IterateForever
            )
            Spacer(modifier = Modifier.height(10.dp))
        }

        if (articles != null) {

            LazyColumn(
                modifier = Modifier.padding(10.dp)
            ) {
                items(articles) { article ->
                    ArticleItem(
                        article!!, onClick = {
                            viewModel.selectArticle(article)
                            navController.navigate("detail")
                        }, viewModel = viewModel
                    )
                }
            }
        } else {
            Loading()
        }
    }


}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ArticleItem(article: ArticlesItem, onClick: () -> Unit, viewModel: HomeViewModel) {

    val showShimmer = remember { mutableStateOf(true) }

    Card(
        modifier = Modifier.padding(vertical = 6.dp),
        onClick = { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            AsyncImage(
                model = article.jetpackFeaturedMediaUrl,
                contentDescription = "Featured Image",
                modifier = Modifier
                    .background(
                        shimmerBrush(
                            targetValue = 1300f, showShimmer = showShimmer.value
                        )
                    )
                    .height(150.dp)
                    .fillMaxWidth(),
                onSuccess = { showShimmer.value = false },
                contentScale = ContentScale.FillWidth,
            )
            Text(
                text = viewModel.cleanHTMLContent(article.title?.rendered),
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = viewModel.formatDate(article.dateGmt!!),
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.TopStart),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}