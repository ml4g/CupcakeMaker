package com.lagvna.cupcakemaker.view.components.cupcakewizard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.lagvna.cupcakemaker.R
import com.lagvna.cupcakemaker.enumerators.ViewIDs
import com.lagvna.cupcakemaker.view.components.CustomSpacer
import com.lagvna.cupcakemaker.viewmodel.CupcakeMakerViewModel

@Composable
fun FinishScreen (navController: NavController,
                  cupcakeMakerViewModel: CupcakeMakerViewModel) {
   // Text("Finish Placeholder")

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            val lottieComposition by rememberLottieComposition(
                LottieCompositionSpec.RawRes(R.raw.finish)
            )

            LottieAnimation(
                composition = lottieComposition,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier.size(400 .dp)
                    .fillMaxWidth()
                    .align(alignment = Alignment.Center)
            )

        }

        Text(
            text = stringResource(R.string.Thanks),
            modifier = Modifier.padding(16 .dp),
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )
        CustomSpacer(height = 8 .dp)
        Button(
            modifier = Modifier.fillMaxWidth()
                .padding(16 .dp),
            onClick = {
                cupcakeMakerViewModel.reset()
                navController.navigate(ViewIDs.Start.id)
            }
        ) {
           Text(text = stringResource(R.string.start_over))
        }

    }
}
