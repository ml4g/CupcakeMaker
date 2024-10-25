package com.ebc.cupcakemaker.view.components.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition


import com.lagvna.cupcakemaker.R
import com.lagvna.cupcakemaker.enumerators.ViewIDs
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true ){
        delay(2000)
        navController.navigate(ViewIDs.Home.id)
    }

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        val composition by rememberLottieComposition(
            LottieCompositionSpec.RawRes(R.raw.cat)
        )

        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier
                .size(500.dp)
                .fillMaxWidth()
                .align(alignment = Alignment.Center)
        )
    }
}