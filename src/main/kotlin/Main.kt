fun main() {
    val cardType = "visa"
    val lastTransaction = 100_000
    val previousTransactions = 140_000

    commissionCalc(cardType, lastTransaction, previousTransactions)
}

fun commissionCalc(cardType: String, lastTransaction: Int, previousTransactions: Int) {
    when (cardType) {
        "vk pay" -> if (previousTransactions > 40_000) println("Превышена сумма транзакций в месяц.")
        else vkPay(lastTransaction)

        "visa", "mir" -> if (previousTransactions > 600_000) println("Превышена сумма транзакций в месяц.")
        else visa(lastTransaction)

        "mastercard", "maestro" -> if (previousTransactions > 600_000) println("Превышена сумма транзакций в месяц.")
        else mastercard(lastTransaction)
    }
}

fun mastercard(lastTransaction: Int) {
    if (lastTransaction > 150_000) println("Превышена сумма последней транзакции.")
    else println("Комиссии нет.")
}

fun visa(lastTransaction: Int) {
    if (lastTransaction > 150_000) println("Превышена сумма последней транзакции.")
    else {
        val commissionInPercent = 0.0075
        val minCommission = 35
        val commission = (lastTransaction * commissionInPercent)
        val result = if (commission > minCommission) commission * 100 else minCommission * 100
        println("Комиссия составляет: $result коп.")
    }
}

fun vkPay(lastTransaction: Int) {
    if (lastTransaction > 15_000) println("Превышена сумма последней транзакции.")
    else println("Комиссии нет.")
}





