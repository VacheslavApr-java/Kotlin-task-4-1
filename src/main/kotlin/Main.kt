val maxLimitInDay = 150_000
val maxLimitInMonthCard = 600_000
val maxLimitInMonthVkPay = 40_000
val maxLimitInMonthPromo = 75_000
val maxLimitOnce = 15_000
val baseCommisionMaestro = 0.006
val baseCommisionVisa = 0.0075
val minBaseCommisionMaestro = 20.0
val minBaseCommisionVisa = 35.0


fun main() {
    resultCommision("Maestro", 1_000, 80_000, 0)
}

fun resultCommision(
    typeCard: String,
    amount: Int,
    maxAmountInMonth: Int = 0,
    maxAmountInDay: Int
): String =

    when (typeCard) {
        "MasterCard" -> resultCommisionMasterCardMaestro(amount, maxAmountInMonth, maxAmountInDay)
        "Maestro" -> resultCommisionMasterCardMaestro(amount, maxAmountInMonth, maxAmountInDay)
        "Visa" -> resultCommisionVisaMir(amount, maxAmountInMonth, maxAmountInDay)
        "МИР" -> resultCommisionVisaMir(amount, maxAmountInMonth, maxAmountInDay)
        "Vk Pay" -> resultCommisionVkPay(amount, maxAmountInMonth)
        else -> "платежная система не определена!"
    }


fun resultCommisionMasterCardMaestro(
    amount: Int,
    maxAmountInMonth: Int = 0,
    maxAmountInDay: Int = 0
): String =
    when {
        maxAmountInDay > maxLimitInDay -> "Превышен максимальный лимит суммы перевода ($maxLimitInDay руб.) в день!"
        maxAmountInMonth > maxLimitInMonthCard -> "Превышен максимальный лимит суммы перевода ($maxLimitInMonthCard руб.) в месяц!"
        maxAmountInMonth > maxLimitInMonthPromo -> "Ваша комиссия с суммы $amount руб. составит " +
                "${amount * baseCommisionMaestro + minBaseCommisionMaestro} руб."
        else -> "Коммисия за данный перевод остуствует"
    }

fun resultCommisionVisaMir(
    amount: Int,
    maxAmountInMonth: Int = 0,
    maxAmountInDay: Int = 0
): String =
    when {
        maxAmountInDay > maxLimitInDay -> "Превышен максимальный лимит суммы перевода ($maxLimitInDay руб.) в день!"
        maxAmountInMonth > maxLimitInMonthCard -> "Превышен максимальный лимит суммы перевода ($maxLimitInMonthCard руб.) в месяц!"
        amount * baseCommisionVisa < minBaseCommisionVisa -> "Ваша комиссия с суммы $amount руб. составит $minBaseCommisionVisa руб."
        else -> "Ваша комиссия с суммы $amount руб. составит " + "${amount * baseCommisionVisa} руб."
    }

fun resultCommisionVkPay(
    amount: Int,
    maxAmountInMonth: Int
): String =
    when {
        amount > maxLimitOnce -> "Превышен лимит перевода ($maxLimitOnce руб. за 1 раз)!"
        maxAmountInMonth > maxLimitInMonthVkPay -> "Превышен максимальный лимит суммы перевода ($maxLimitInMonthVkPay руб.) в месяц!"
        else -> "Коммисия за данный перевод остуствует"
    }

