package it.intre.reloadedCamp.kotlin

import it.intre.reloadedCamp.java.Checkout

class ImprovedCheckout: Checkout {

    override fun pay(items: List<String>, offers: Map<String, Map.Entry<Int, Int>>): Int {
        return 0
    }

}