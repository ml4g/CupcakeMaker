package com.lagvna.cupcakemaker.view.components.cupcakewizard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lagvna.cupcakemaker.R
import com.lagvna.cupcakemaker.enumerators.ViewIDs
import com.lagvna.cupcakemaker.enumerators.ViewModelIDs
import com.lagvna.cupcakemaker.staticdata.DataSource
import com.lagvna.cupcakemaker.view.components.CustomSpacer
import com.lagvna.cupcakemaker.viewmodel.CupcakeMakerViewModel
import org.w3c.dom.Text


@Composable
fun SelectFlavorScreen(navController: NavController,
                       cupcakeMakerViewModel: CupcakeMakerViewModel){
    //Text(text = "Flavors!!!!")
    //Función anónima (lambda) --> { key -> stringResource(key) }
    val flavors = DataSource.flavorsKeys.map { key -> stringResource(key) }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column (
            modifier = Modifier.padding(16 .dp)
        ){
            flavors.forEach { flavor ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = cupcakeMakerViewModel.state.flavor == flavor,
                            onClick = {
                                cupcakeMakerViewModel.onValue(flavor, ViewModelIDs.Flavor.id)

                            }
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = cupcakeMakerViewModel.state.flavor == flavor,
                        onClick = {
                            cupcakeMakerViewModel.onValue(flavor, ViewModelIDs.Flavor.id)
                        }
                    )
                    Text(text = flavor)
                }

            }
            CustomSpacer(height = 16 .dp)
            TextField(
                value = cupcakeMakerViewModel.state.extraInstructions,
                onValueChange = { newExtraIns ->
                    cupcakeMakerViewModel.onValue(newExtraIns, ViewModelIDs.ExtraInstructions.id)},
                label = { Text(stringResource(R.string.extra_instructions))},
                maxLines = Int.MAX_VALUE,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                textStyle = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100 .dp)
                    .verticalScroll(rememberScrollState())
                    .padding(16 .dp)
            )
            CustomSpacer(height = 16 .dp)
            HorizontalDivider(
                thickness = 1 .dp,
                modifier = Modifier.padding(16 .dp)
            )
            Text(
                text = stringResource(R.string.subtotal,
                    cupcakeMakerViewModel.state.total),
                modifier = Modifier
                    .padding(horizontal = 16 .dp),
                style = MaterialTheme.typography.headlineSmall
            )

        }
        CustomSpacer(height = 16 .dp)
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16 .dp),
            horizontalArrangement = Arrangement.spacedBy(20 .dp),
            verticalAlignment = Alignment.Bottom
        ) {
            OutlinedButton(
                modifier = Modifier.weight(1F),
                onClick = {
                    cupcakeMakerViewModel.reset()
                    navController.popBackStack(
                        ViewIDs.Start.id, false
                    )
                }
            ) {
                Text(stringResource(R.string.cancel))
            }
            Button(
                modifier = Modifier.weight(1F),
                onClick = {
                    navController.navigate(ViewIDs.SelectDate.id)
                },
                enabled = cupcakeMakerViewModel.state.flavor.isNotEmpty()
            ) {
                Text(stringResource(R.string.next))
            }
        }

    }


}