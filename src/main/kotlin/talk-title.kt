fun times() = with (colleagues) { studying { Kotlin in guild } }


/**
 * Vi presentiamo Kotlin:
 *  - linguaggio di programmazione tipizzato staticamente
 *  - interoperabile con Java ed Android
 *  - eseguito sulla JVM
 *  - multi-paradigma (ad oggetti, funzionale, ...)
 *  - semplice, conciso, facile da leggere
 *  - supera molti dei difetti di Java (es. "Effective Java" di Joshua Bloch)
 *  - creato da JetBrains e supportato ottimamente da IntelliJ
 *
 * Faremo refactoring di un blocco di codice cercando di
 *  migliorarne la qualità e renderlo più espressivo.
 *
 * Come esempio, useremo un classico kata per la gestione delle offerte di un supermercato.
 */



const val Kotlin = "Kotlin"
const val guild = "Kotlin language is cool!"
const val colleagues = "i3"
fun studying(`subject is interesting`: () -> Boolean) =
        if (`subject is interesting`()) "YEAH!" else ":-("
fun main(args: Array<String>) = println(times())