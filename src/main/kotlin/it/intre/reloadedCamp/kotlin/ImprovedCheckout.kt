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

        val quantities = items
                .groupBy { it }
                .mapValues { (_, v) -> v.size }

        for ((item, offer) in offers) {
            // TODO check for offers
        }

        return prices.entries
                .sumBy { (item, price) -> (quantities[item] ?: 0) * price }
    }

}