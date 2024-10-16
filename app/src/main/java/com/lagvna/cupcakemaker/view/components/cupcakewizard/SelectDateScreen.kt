package com.lagvna.cupcakemaker.view.components.cupcakewizard

import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.lagvna.cupcakemaker.viewmodel.CupcakeMakerViewModel
import java.text.SimpleDateFormat
import java.util.Calendar


fun createPickupOptions() : List<String>{
    val dateOptions = mutableListOf<String>()
    val dateFormat = SimpleDateFormat("E MMM d")
    val calendar = Calendar.getInstance()

    repeat(5){
        dateOptions.add(dateFormat.format(calendar.time))
        calendar.add(Calendar.DATE, 1)
    }

    return dateOptions

}


@Composable
fun SelectDateScreen(navContoller: NavController,
                     cupcakeMakerViewModel: CupcakeMakerViewModel
) {
    //Text("Select Date Placeholder")

}