package com.lagvna.cupcakemaker.view.navigation

import android.view.View
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lagvna.cupcakemaker.enumerators.ViewIDs
import com.lagvna.cupcakemaker.view.components.cupcakewizard.OrderSummaryScreen
import com.lagvna.cupcakemaker.view.components.cupcakewizard.SelectDateScreen
import com.lagvna.cupcakemaker.view.components.cupcakewizard.SelectFlavorScreen
import com.lagvna.cupcakemaker.view.components.cupcakewizard.StartOrderScreen
import com.lagvna.cupcakemaker.viewmodel.CupcakeMakerViewModel
import org.w3c.dom.Text

//TODO: Crear función para el topbar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CupcakeAppBar(){
    CenterAlignedTopAppBar(
        title = {"Título placeholder"},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )

    )
}


//TODO: Cear el nav manager
@Composable
fun NavigationManager(cupcakeMakerViewModel: CupcakeMakerViewModel) {
    val navController = rememberNavController();

    Scaffold(
        topBar = {CupcakeAppBar()},
        bottomBar = {Text(text = "I´m the bottom container") }

    ) {
        NavHost(
            navController = navController,
            startDestination = ViewIDs.Start.id,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ){
            composable("Home") {
                Text(text= "Placeholder Home")
            }
            composable (ViewIDs.Start.id) {
                StartOrderScreen(navController, cupcakeMakerViewModel)
            }
            composable(route = ViewIDs.Flavors.id) {
                SelectFlavorScreen(navController, cupcakeMakerViewModel)
            }
            composable(ViewIDs.SelectDate.id) {
                SelectDateScreen(navController, cupcakeMakerViewModel)
            }
            composable(ViewIDs.OrderSummary.id) {
                OrderSummaryScreen(navController, cupcakeMakerViewModel)
            }
        }
    }
}