package com.lagvna.cupcakemaker.view.components.cupcakewizard

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.GraphicsContext
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lagvna.cupcakemaker.R
import com.lagvna.cupcakemaker.viewmodel.CupcakeMakerViewModel
import javax.security.auth.Subject


private fun ShareOrder(context: Context, title:String, subject: String, summary: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, summary)
    }

    context.startActivity(
        Intent.createChooser(
            intent,
            title
        )
    )

}


@Composable
fun OrderSummaryScreen(navController: NavController,
                       cupcakeMakerViewModel: CupcakeMakerViewModel){

    //Text("Order Summary Placeholder")
    val context = LocalContext.current
    //val resources = context.resources

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column (
            modifier = Modifier.padding(16 .dp),
            verticalArrangement = Arrangement.spacedBy(8 .dp)
        ) {
           Text(stringResource(R.string.quantity).uppercase())
           Text(
               text = cupcakeMakerViewModel.state.quantity.toString()
                       + " " + stringResource(R.string.cupcake_tag),
               fontWeight = FontWeight.Bold

          )
            HorizontalDivider(thickness = 1 .dp)

            //-----------------------------------
            Text(stringResource(R.string.flavor).uppercase())
            Text(
                text = cupcakeMakerViewModel.state.flavor,
                fontWeight = FontWeight.Bold

            )
            HorizontalDivider(thickness = 1 .dp)

            //-----------------------------------
            Text(stringResource(R.string.pickup_date).uppercase())
            Text(
                text = cupcakeMakerViewModel.state.pickupDate,
                fontWeight = FontWeight.Bold

            )
            HorizontalDivider(thickness = 1 .dp)

            //-----------------------------------
            Text(stringResource(R.string.extra_instructions).uppercase())
            Text(
                text = cupcakeMakerViewModel.state.extraInstructions,
                fontWeight = FontWeight.Bold

            )
            HorizontalDivider(thickness = 1 .dp)

            //-----------------------------------
            Text(stringResource(R.string.pickup_instructions).uppercase())
            Text(
                text = cupcakeMakerViewModel.state.pickupInstructions,
                fontWeight = FontWeight.Bold

            )
            HorizontalDivider(thickness = 1 .dp)

            //-----------------------------------

            Text(
                text = stringResource(R.string.subtotal,
                    cupcakeMakerViewModel.state.total),
                style = MaterialTheme.typography.headlineSmall

            )

        }
        Row(modifier = Modifier.padding(16 .dp)){
            Column(verticalArrangement = Arrangement.spacedBy(8 .dp)){
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        ShareOrder(context, "Orden final",
                            "Nueva Orden",
                            "Resumen")

                    }
                ) {
                    Text(stringResource(R.string.share))

                }
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF138303)
                    )
                ) {
                    Text(stringResource(R.string.send))
                }
            }
        }

    }




}