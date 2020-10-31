fun main() {
    val cardType = "vk pay"
    val lastTransaction = 100_000
    val previousTransaction = 0

    val result = commissionCalc(cardType, lastTransaction, previousTransaction)
    println("Комиссия составляет: $result коп.")
}

fun commissionCalc(cardType: String, lastTransaction: Int, previousTransaction: Int): Int {
    var commission = 0
    when (cardType) {
        "vk pay"  -> commission = 0
        "mastercard" -> commission = commissionCountForMasterCard(lastTransaction, previousTransaction)
        "visa", "mir" -> commission = commissionCountForVisa(lastTransaction)
    }
    return commission
}

fun commissionCountForMasterCard(lastTransaction: Int, previousTransaction: Int): Int {
    val commissionInPercent = 0.006

    return if (previousTransaction > 7_500_000)
        (lastTransaction * commissionInPercent).toInt() + 2_000
    else 0
}

fun commissionCountForVisa(lastTransaction: Int): Int {
    val commissionInPercent = 0.0075
    val minCommission = 3_500
    val commission = (lastTransaction * commissionInPercent).toInt()
    return if (commission > minCommission) commission else minCommission
}





