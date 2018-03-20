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

    override fun pay(items: List<String>, offers: Map<String, Pair<Int, Int>>): Int {

        val quantities = items
                .groupBy { it }
                .mapValues { (_, v) -> v.size }
                .toMutableMap()

        var offerTotal = 0
        for ((item, offer) in offers) {
            val (offerQuantity, offerPrice) = offer
            val quantity = quantities[item]
            if (quantity != null && offerQuantity <= quantity) {
                val repeat = quantity / offerQuantity
                offerTotal += repeat * offerPrice
                quantities[item] = quantity - repeat * offerQuantity
            }
        }

        return offerTotal +
                prices.entries.sumBy { (item, price) -> (quantities[item] ?: 0) * price }
    }

}