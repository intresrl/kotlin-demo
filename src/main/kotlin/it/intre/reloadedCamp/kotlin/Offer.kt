package it.intre.reloadedCamp.kotlin


data class Offer(val item: Item, val offerQuantity: Int, val offerPrice: Int) {
    fun pay(quantity: Int, price: Int) =
            quantity / offerQuantity * offerPrice + quantity % offerQuantity * price
}