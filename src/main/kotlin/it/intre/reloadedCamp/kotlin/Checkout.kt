package it.intre.reloadedCamp.kotlin

interface Checkout {
    fun pay(items: List<Item>, offers: List<Offer>): Int
}
