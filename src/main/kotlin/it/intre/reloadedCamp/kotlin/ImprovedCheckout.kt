package it.intre.reloadedCamp.kotlin

import it.intre.reloadedCamp.java.Checkout
import kotlin.collections.Map.Entry

const val APPLE = "apple"
const val PEAR = "pear"
const val PINEAPPLE = "pineapple"
const val BANANA = "banana"

class ImprovedCheckout : Checkout {

    private val prices = mapOf(
            APPLE to 50,
            PEAR to 30,
            PINEAPPLE to 220,
            BANANA to 60
    )

    override fun pay(items: List<String>, offers: Map<String, Entry<Int, Int>>): Int {
        var res = 0

        val quantities = mutableMapOf<String, Int>()

        for (item in items) {
            quantities[item] = 1 + (quantities[item] ?: 0)
        }

        for ((item, offer) in offers) {
            // TODO check for offers
        }

        for ((item, price) in prices) {
            res += (quantities[item] ?: 0) * price
        }

        return res
    }

}