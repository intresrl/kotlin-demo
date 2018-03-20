package it.intre.reloadedCamp.kotlin

class ImprovedCheckout : Checkout {

    override fun pay(items: List<Item>, offers: Map<Item, Pair<Int, Int>>) =
            items
                    .groupBy { it }
                    .mapValues { (_, v) -> v.size }
                    .entries
                    .sumBy { (item, quantity) -> payItem(offers[item], quantity, item.price) }

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