package com.hishd.tinycart.exception

class ItemtNotFoundException(message: String = "The Item is not found inside the cart.") : RuntimeException(message) {
}