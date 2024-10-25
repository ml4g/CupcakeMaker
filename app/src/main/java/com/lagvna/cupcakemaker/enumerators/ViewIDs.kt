package com.lagvna.cupcakemaker.enumerators

import android.nfc.Tag

enum class ViewIDs(val id:String, val tag: String) {
    Splash(id = "Splash", tag = "Splash"),
    Home(id = "Home", tag = "Home"),
    Start(id = "Start", tag = "Start"),
    Flavors(id = "Flavors", tag = "Flavors"),
    SelectDate(id = "SelectDate", tag = "Select Date"),
    OrderSummary(id = "OrderSummary", tag = "Order Summary"),
    FinishOrder(id = "FinishOrder", tag = "Finish Order")

}