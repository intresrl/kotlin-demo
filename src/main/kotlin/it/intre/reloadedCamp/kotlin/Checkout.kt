package it.intre.reloadedCamp.kotlin

interface Checkout {
    fun pay(items: List<Item>, offers: Map<Item, Pair<Int, Int>>): Int
}
