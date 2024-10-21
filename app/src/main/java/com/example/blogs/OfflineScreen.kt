package com.example.blogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun OfflineScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //rememberLottieComposition is a lottie compose function to load the lottie asynchronously
        //remember is used to cache the lottie
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.no_network))
        LottieAnimation(
            modifier = Modifier.fillMaxWidth(),
            composition = composition,
            iterations = LottieConstants.IterateForever
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "NO NETWORK :(", style = MaterialTheme.typography.headlineLarge)
    }
}