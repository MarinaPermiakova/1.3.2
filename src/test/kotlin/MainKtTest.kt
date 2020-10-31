import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commissionCalcVisa() {
        val userCardType = "visa"
        val userLastTransaction = 10_000_000
        val userPreviousTransaction = 140_000

        val result = commissionCalc(
                cardType = userCardType,
                lastTransaction = userLastTransaction,
                previousTransaction = userPreviousTransaction
        )

        assertEquals(75_000, result)
    }

    @Test
    fun minCommissionCalcVisa() {
        val userCardType = "visa"
        val userLastTransaction = 10_000
        val userPreviousTransaction = 140_000

        val result = commissionCalc(
                cardType = userCardType,
                lastTransaction = userLastTransaction,
                previousTransaction = userPreviousTransaction
        )

        assertEquals(3_500, result)
    }

    @Test
    fun commissionMastercard() {
        val userCardType = "mastercard"
        val userLastTransaction = 170_000
        val userPreviousTransaction = 7_500_001

        val result = commissionCalc(
                cardType = userCardType,
                lastTransaction = userLastTransaction,
                previousTransaction = userPreviousTransaction
        )
        assertEquals(3_020, result)
    }

    @Test
    fun zeroCommissionMastercard() {
        val userCardType = "mastercard"
        val userLastTransaction = 170_000
        val userPreviousTransaction = 7_500_000

        val result = commissionCalc(
                cardType = userCardType,
                lastTransaction = userLastTransaction,
                previousTransaction = userPreviousTransaction
        )
        assertEquals(0, result)
    }


    @Test
    fun commissionVk() {
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