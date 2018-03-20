package it.intre.reloadedCamp.kotlin

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

    override fun pay(items: List<String>, offers: Map<String, Pair<Int, Int>>) =
            items
                    .groupBy { it }
                    .mapValues { (_, v) -> v.size }
                    .entries
                    .sumBy { (item, quantity) -> payItem(offers[item], quantity, prices[item] ?: 0) }

    private fun payItem(offer: Pair<Int, Int>?, quantity: Int, price: Int) =
            when (offer) {
                null -> quantity * price
                else -> compute(offer, quantity, price)
            }

    private fun compute(offer: Pair<Int, Int>, quantity: Int, price: Int): Int {
        val (offerQuantity, offerPrice) = offer
        return quantity / offerQuantity * offerPrice + quantity % offerQuantity * price
    }
}