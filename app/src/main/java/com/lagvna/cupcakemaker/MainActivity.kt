package com.lagvna.cupcakemaker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lagvna.cupcakemaker.ui.theme.CupcakeMakerTheme
import com.lagvna.cupcakemaker.view.navigation.NavigationManager
import com.lagvna.cupcakemaker.viewmodel.CupcakeMakerViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cupcakeMakerViewModel: CupcakeMakerViewModel by viewModels()

        setContent {
            CupcakeMakerTheme {
               Surface(
                   modifier = Modifier.fillMaxSize(),
                   color = MaterialTheme.colorScheme.primaryContainer
               ) {
                   NavigationManager(cupcakeMakerViewModel);
               }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CupcakeMakerTheme {
        Greeting("Android")
    }
}