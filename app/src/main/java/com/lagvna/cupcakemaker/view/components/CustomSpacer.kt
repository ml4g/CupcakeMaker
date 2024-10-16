package com.lagvna.cupcakemaker.view.components

import android.icu.text.ListFormatter.Width
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomSpacer(width: Dp = 0 .dp, height: Dp = 0 .dp) {
    Spacer(modifier = Modifier
        .width(width)
        .height(height)
    )

}