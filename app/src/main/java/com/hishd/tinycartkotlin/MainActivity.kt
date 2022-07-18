package com.hishd.tinycartkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hishd.tinycart.model.Cart
import com.hishd.tinycartkotlin.model.ElectronicItem
import com.hishd.tinycartkotlin.model.GroceryItem

class MainActivity : AppCompatActivity() {

    private val TAG = "CART"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cart = Cart.getCart()

        //Creating Item instances
        val iPhone13 = ElectronicItem("iPhone 13", 100.0)
        val milk = GroceryItem("Milk", 20.0)

        //Add Items to the Cart
        cart.addItem(iPhone13, 10)
        cart.addItem(milk, 5)


        //View the items within cart
        Log.i(TAG, cart.toString())

        //Update Items within th cart (update quantity)
        cart.updateQuantity(iPhone13, 8)
        cart.updateQuantity(milk, 15)
        Log.i(TAG, cart.toString())

        //Get Item Quantity
        Log.i(TAG, "Item Quantity of iPhone is : ${cart.getItemQty(iPhone13)}")

        //Get the total price of the cart(all items)
        Log.i(TAG, "Cart Total : ${cart.getTotalPrice()}")

        //Get all item names in the cart
        for(item in cart.getItemNames()) {
            Log.i(TAG, "Item Name : $item")
        }

        //Reduce the quantity
        cart.removeQuantity(iPhone13, 5)
        Log.i(TAG, cart.toString())

        //Remove Item
        cart.removeItem(iPhone13)
        Log.i(TAG, cart.toString())

        //Clear the cart
        cart.clearCart()
        Log.i(TAG, cart.toString())

        //Check whether the cart is empty
        Log.i(TAG, "Cart Empty Status : ${cart.isCartEmpty()}")
    }
}