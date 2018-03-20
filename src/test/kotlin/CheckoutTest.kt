import it.intre.reloadedCamp.kotlin.Checkout
import it.intre.reloadedCamp.kotlin.ImprovedCheckout
import it.intre.reloadedCamp.kotlin.Item
import it.intre.reloadedCamp.kotlin.Item.*
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.*
import java.util.stream.Stream

internal class CheckoutTest {

    private val withNoOffers = HashMap<Item, Pair<Int, Int>>()

    private fun withOffers(quantity: Int, fruit: Item, offerPrice: Int): MutableMap<Item, Pair<Int, Int>> {
        val offers = mutableMapOf<Item, Pair<Int, Int>>()
        offers[fruit] = Pair(quantity, offerPrice)
        return offers
    }

    private fun forFruits(vararg fruits: Item): List<Item> {
        return Arrays.asList(*fruits)
    }

    @ParameterizedTest
    @ArgumentsSource(Checkouts::class)
    fun shouldSellAnApple(checkout: Checkout) {
        val expectedPrice = 50
        assertEquals(expectedPrice.toLong(), checkout.pay(forFruits(APPLE), withNoOffers).toLong())
    }

    @ParameterizedTest
    @ArgumentsSource(Checkouts::class)
    @Throws(Exception::class)
    fun aPineappleCosts220(checkout: Checkout) {
        val expectedPrice = 220
        assertEquals(expectedPrice.toLong(), checkout.pay(forFruits(PINEAPPLE),
                withOffers(1, PINEAPPLE, 220)).toLong())
    }

    @ParameterizedTest
    @ArgumentsSource(Checkouts::class)
    @Throws(Exception::class)
    fun aBananaCosts60(checkout: Checkout) {
        val expectedPrice = 60
        assertEquals(expectedPrice.toLong(), checkout.pay(forFruits(BANANA), withOffers(1, BANANA, 60)).toLong())
    }

    @ParameterizedTest
    @ArgumentsSource(Checkouts::class)
    fun fruits(checkout: Checkout) {
        val ll = withOffers(3, APPLE, 130)
        ll[PEAR] = Pair(2, 45)

        val expectedPrice = 455
        assertEquals(expectedPrice.toLong(), checkout.pay(
                forFruits(APPLE, PEAR, APPLE, PEAR, APPLE, BANANA, PINEAPPLE),
                ll).toLong())
    }

    @ParameterizedTest
    @ArgumentsSource(Checkouts::class)
    fun repeatedOffer(checkout: Checkout) {
        val ll = withOffers(2, APPLE, 75)

        val expectedPrice = 2 * 75 + 30
        assertEquals(expectedPrice.toLong(), checkout.pay(
                forFruits(APPLE, APPLE, APPLE, APPLE, PEAR),
                ll).toLong())
    }

    internal class Checkouts : ArgumentsProvider {
        @Throws(Exception::class)
        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> {
            return Stream.of(ImprovedCheckout())
                    .map { Arguments.of(it) }
        }
    }
}