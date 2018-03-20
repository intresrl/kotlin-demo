package it.intre.reloadedCamp.kotlin

interface Checkout {
    fun pay(items: List<String>, offers: Map<String, Pair<Int, Int>>): Int
}
