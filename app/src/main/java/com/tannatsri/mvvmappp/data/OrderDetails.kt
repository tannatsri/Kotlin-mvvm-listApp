package com.tannatsri.mvvmappp.data

data class OrderStatus (
    val title:String,
    val message:String,
    val button_text:String
    )

data class OrderDetails (
    val title:String,
    val order_summary:String,
    val order_value:String,
    val share_value:String
)


data class OrderData (val order_status: OrderStatus, val order_details: OrderDetails, val home_button_text: String)