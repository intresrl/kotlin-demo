package it.intre.reloadedCamp.kotlin

class ImprovedCheckout : Checkout {

    override fun pay(items: List<Item>, offers: List<Offer>) =
            items
                    .groupBy { it }
                    .mapValues { (_, v) -> v.size }
                    .toList()
                    .sumBy { (item, quantity) -> payItemWithOffers(offers, item, quantity) }

    private fun payItemWithOffers(offers: List<Offer>, item: Item, quantity: Int) =
            payItem(offers.find { it.item == item }, quantity, item.price)

    private fun payItem(offer: Offer?, quantity: Int, price: Int) =
            when (offer) {
                null -> quantity * price
                else -> offer.pay(quantity, price)
            }

}