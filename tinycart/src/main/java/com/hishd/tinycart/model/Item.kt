package com.hishd.tinycart.model

interface Item {
    val price: Double
    val name: String

    fun getItemPrice() : Double
    fun getItemQuantity(): Int
}