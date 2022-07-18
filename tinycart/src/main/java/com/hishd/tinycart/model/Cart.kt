package com.hishd.tinycart.model

import com.hishd.tinycart.exception.InvalidQuantityException
import com.hishd.tinycart.exception.ItemtNotFoundException

object Cart {
    private val cartItems: MutableMap<Item, Int> = mutableMapOf()

    @Throws(InvalidQuantityException::class)
    fun addItem(item: Item, quantity: Int) {
        if (quantity == 0)
            throw InvalidQuantityException()

        if (cartItems.containsKey(item)) {
            cartItems[item] = cartItems[item]!!.plus(quantity)
            return
        }

        cartItems[item] = quantity
    }

    @Throws(ItemtNotFoundException::class, InvalidQuantityException::class)
    fun updateItem(item: Item, quantity: Int) {
        if (quantity == 0)
            throw InvalidQuantityException()
        if (!cartItems.containsKey(item))
            throw ItemtNotFoundException()

        cartItems[item] = cartItems[item]!!.plus(quantity)
    }

    @Throws(ItemtNotFoundException::class, InvalidQuantityException::class)
    fun removeQuantity(item: Item, quantity: Int) {
        if (quantity == 0)
            throw InvalidQuantityException()
        if (!cartItems.containsKey(item))
            throw ItemtNotFoundException()

        if (quantity > cartItems[item]!!) {
            throw InvalidQuantityException("Invalid Item Quantity, the quantity should be greater than zero and the previous quantity of the item.")
        }

        if (quantity == cartItems[item]!!)
            cartItems.remove(item)
        else
            cartItems[item] = cartItems[item]!!.minus(quantity)
    }

    @Throws(ItemtNotFoundException::class)
    fun removeItem(item: Item) {
        if (!cartItems.containsKey(item))
            throw ItemtNotFoundException()
        cartItems.remove(item)
    }

    fun clearCart() = cartItems.clear()

    fun isCartEmpty() = cartItems.isEmpty()

    @Throws(ItemtNotFoundException::class)
    fun getItemQty(item: Item): Int {
        if (!cartItems.containsKey(item))
            throw ItemtNotFoundException()
        return cartItems[item]!!
    }

    fun getTotalPrice(): Double {
        return cartItems.map {
            it.key.price * it.value
        }.sum()
    }

    fun getItemNames() : List<String> {
        return cartItems.map {
            it.key.name
        }.toList()
    }

    fun getItemsWithQuantity() : Map<Item, Int> = cartItems
}