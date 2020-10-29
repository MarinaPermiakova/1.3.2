import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commissionCalc() {
        val userCardType = "visa"
        val userLastTransaction = 100_000
        val userPreviousTransaction = 140_000

        val result = commissionCalc(
            cardType = userCardType,
            lastTransaction = userLastTransaction,
            previousTransaction = userPreviousTransaction
        )

        assertEquals(75_000, result)
    }

    @Test
    fun commissionCalcZeroCommission() {
        val userCardType = "mastercard"
        val userLastTransaction = 170_000
        val userPreviousTransaction = 140_000

        val result = commissionCalc(
            cardType = userCardType,
            lastTransaction = userLastTransaction,
            previousTransaction = userPreviousTransaction
        )
        assertEquals(0, result)
    }

    @Test
    fun commissionCalcVkCommission() {
        val userCardType = "vk pay"
        val userLastTransaction = 170_000
        val userPreviousTransaction = 140_000

        val result = commissionCalc(
            cardType = userCardType,
            lastTransaction = userLastTransaction,
            previousTransaction = userPreviousTransaction
        )
        assertEquals(0, result)
    }
}