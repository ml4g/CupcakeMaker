package com.lagvna.cupcakemaker.view.navigation

import android.view.View
import android.window.SplashScreen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ebc.cupcakemaker.view.components.onboarding.MainOnboarding
import com.ebc.cupcakemaker.view.components.splash.SplashScreen
import com.lagvna.cupcakemaker.enumerators.ViewIDs
import com.lagvna.cupcakemaker.view.components.cupcakewizard.FinishScreen
import com.lagvna.cupcakemaker.view.components.cupcakewizard.OrderSummaryScreen
import com.lagvna.cupcakemaker.view.components.cupcakewizard.SelectDateScreen
import com.lagvna.cupcakemaker.view.components.cupcakewizard.SelectFlavorScreen
import com.lagvna.cupcakemaker.view.components.cupcakewizard.StartOrderScreen
import com.lagvna.cupcakemaker.viewmodel.CupcakeMakerViewModel
import org.w3c.dom.Text

//TODO: Crear función para el topbar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CupcakeAppBar(currentScreen: ViewIDs){
    CenterAlignedTopAppBar(
        title = { Text(currentScreen.tag) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )

    )
}


//TODO: Cear el nav manager
@Composable
fun NavigationManager(cupcakeMakerViewModel: CupcakeMakerViewModel) {
    val navController = rememberNavController();

    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = ViewIDs.valueOf(
        backStackEntry?.destination?.route ?:ViewIDs.Start.id
    )

    Scaffold(
        topBar = {
            if (currentScreen !in listOf(ViewIDs.Splash, ViewIDs.Home, ViewIDs.FinishOrder)) {
                CupcakeAppBar(currentScreen)
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Text(text = "Cupcake Maker 1.0")}
        }

    ) {
        NavHost(
            navController = navController,
            startDestination = ViewIDs.Splash.id,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            composable(ViewIDs.Splash.id) {
                SplashScreen(navController)
            }
            composable(ViewIDs.Home.id) {
                MainOnboarding(navController)
            }
            composable(ViewIDs.Start.id) {
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
            composable(ViewIDs.FinishOrder.id) {
                FinishScreen(navController, cupcakeMakerViewModel)
            }
        }
    }
}