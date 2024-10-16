package com.lagvna.cupcakemaker.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.lagvna.cupcakemaker.enumerators.ViewModelIDs
import com.lagvna.cupcakemaker.model.CupcakeOrderState

class CupcakeMakerViewModel: ViewModel () {

    var state by mutableStateOf(CupcakeOrderState())
        private set

    /**
     * Si alguien solicita un cambio al state, esta funcion se encargará de ejecutar el cambio
     * Opciones disponibles: flavor, quantity, price, pickupDate, extraInstructions,
     * pickupInstructions
     * */
    fun onValue(value:String, textId: String) {
        when (textId) {
            ViewModelIDs.Flavor.id -> state = state.copy(flavor = value);
            ViewModelIDs.Quantity.id -> {
                state = state.copy(quantity = value.toInt());
                calculateTotalAmount();
            }
            "price" ->  {
                state = state.copy(price = value.toDouble());
                calculateTotalAmount();
            }
            ViewModelIDs.PickupDate.id -> state = state.copy(pickupDate = value);
            ViewModelIDs.ExtraInstructions.id -> state = state.copy(extraInstructions = value);
            ViewModelIDs.PickupInstructions.id -> state = state.copy(pickupInstructions = value);

        }
    }

    /**
     * Función para calcular total de la orden
     * */
    private fun calculateTotalAmount() {
        val quantity = state.quantity;
        val price = state.price;
        val total = quantity * price;

        state = state.copy(total = total)
    }

    /**
     * Función para hacer un reset a la orden e inciar de nuevo
     * */
    fun reset() {
        state = CupcakeOrderState()
    }

}