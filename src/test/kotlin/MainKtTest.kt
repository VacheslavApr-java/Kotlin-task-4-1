import org.junit.Assert.*
import org.junit.Test

class MainKtTest {

    @Test
    fun resultCommision_type_Maestro() {
        val typeCard = "Maestro"
        val amount = 1_000
        val maxAmountInMonth = 0
        val maxAmountInDay = 200_000
        val expected = "Превышен максимальный лимит суммы перевода ($maxLimitInDay руб.) в день!"

        val result = resultCommision(
            typeCard = typeCard,
            amount = amount,
            maxAmountInMonth = maxAmountInMonth,
            maxAmountInDay = maxAmountInDay
        )
        assertEquals(expected, result)
    }

    @Test
    fun resultCommision_type_MasterCard() {
        val typeCard = "MasterCard"
        val amount = 1_000
        val maxAmountInMonth = 0
        val maxAmountInDay = 170_000
        val expected = "Превышен максимальный лимит суммы перевода ($maxLimitInDay руб.) в день!"

        val result = resultCommision(
            typeCard = typeCard,
            amount = amount,
            maxAmountInMonth = maxAmountInMonth,
            maxAmountInDay = maxAmountInDay
        )
        assertEquals(expected, result)
    }

    @Test
    fun resultCommision_type_Visa() {
        val typeCard = "Visa"
        val amount = 1_000
        val maxAmountInMonth = 0
        val maxAmountInDay = 250_000
        val expected = "Превышен максимальный лимит суммы перевода ($maxLimitInDay руб.) в день!"

        val result = resultCommision(
            typeCard = typeCard,
            amount = amount,
            maxAmountInMonth = maxAmountInMonth,
            maxAmountInDay = maxAmountInDay
        )
        assertEquals(expected, result)
    }

    @Test
    fun resultCommision_type_Mir() {
        val typeCard = "МИР"
        val amount = 1_000
        val maxAmountInMonth = 0
        val maxAmountInDay = 250_000
        val expected = "Превышен максимальный лимит суммы перевода ($maxLimitInDay руб.) в день!"

        val result = resultCommision(
            typeCard = typeCard,
            amount = amount,
            maxAmountInMonth = maxAmountInMonth,
            maxAmountInDay = maxAmountInDay
        )
        assertEquals(expected, result)
    }

    @Test
    fun resultCommision_type_VkPay() {
        val typeCard = "Vk Pay"
        val amount = 20_000
        val maxAmountInMonth = 0
        val maxAmountInDay = 0
        val expected = "Превышен лимит перевода ($maxLimitOnce руб. за 1 раз)!"

        val result = resultCommision(
            typeCard = typeCard,
            amount = amount,
            maxAmountInMonth = maxAmountInMonth,
            maxAmountInDay = maxAmountInDay
        )
        assertEquals(expected, result)
    }

    @Test
    fun resultCommision_type_Other() {
        val typeCard = "PayPal"
        val amount = 1_000
        val maxAmountInMonth = 0
        val maxAmountInDay = 200_000
        val expected = "платежная система не определена!"

        val result = resultCommision(
            typeCard = typeCard,
            amount = amount,
            maxAmountInMonth = maxAmountInMonth,
            maxAmountInDay = maxAmountInDay
        )
        assertEquals(expected, result)
    }

    @Test
    fun resultCommisionMasterCardMaestro_more_150_000() {
        val amount = 1_000
        val maxAmountInMonth = 0
        val maxAmountInDay = 200_000
        val expected = "Превышен максимальный лимит суммы перевода ($maxLimitInDay руб.) в день!"

        val result = resultCommisionMasterCardMaestro(
            amount = amount,
            maxAmountInMonth = maxAmountInMonth,
            maxAmountInDay = maxAmountInDay
        )
        assertEquals(expected, result)
    }

    @Test
    fun resultCommisionMasterCardMaestro_more_600_000() {
        val amount = 1_000
        val maxAmountInMonth = 700_000
        val maxAmountInDay = 10_000
        val expected = "Превышен максимальный лимит суммы перевода ($maxLimitInMonthCard руб.) в месяц!"

        val result = resultCommisionMasterCardMaestro(
            amount = amount,
            maxAmountInMonth = maxAmountInMonth,
            maxAmountInDay = maxAmountInDay
        )
        assertEquals(expected, result)
    }

    @Test
    fun resultCommisionMasterCardMaestro_before_75_000() {
        val amount = 1_000
        val maxAmountInMonth = 0
        val maxAmountInDay = 0
        val expected = "Коммисия за данный перевод остуствует"

        val result = resultCommisionMasterCardMaestro(
            amount = amount,
            maxAmountInMonth = maxAmountInMonth,
            maxAmountInDay = maxAmountInDay
        )
        assertEquals(expected, result)
    }

    @Test
    fun resultCommisionMasterCardMaestro_between_75_000_150_000() {
        val amount = 1_000
        val maxAmountInMonth = 80_000
        val maxAmountInDay = 0
        val expected = "Ваша комиссия с суммы $amount руб. составит " +
                "${amount * baseCommisionMaestro + minBaseCommisionMaestro} руб."

        val result = resultCommisionMasterCardMaestro(
            amount = amount,
            maxAmountInMonth = maxAmountInMonth,
            maxAmountInDay = maxAmountInDay
        )
        assertEquals(expected, result)
    }

    @Test
    fun resultCommisionVisaMir_more_150_000() {
        val amount = 1_000
        val maxAmountInMonth = 0
        val maxAmountInDay = 200_000
        val expected = "Превышен максимальный лимит суммы перевода ($maxLimitInDay руб.) в день!"

        val result = resultCommisionVisaMir(
            amount = amount,
            maxAmountInMonth = maxAmountInMonth,
            maxAmountInDay = maxAmountInDay
        )
        assertEquals(expected, result)
    }

    @Test
    fun resultCommisionVisaMir_more_600_000() {
        val amount = 1_000
        val maxAmountInMonth = 700_000
        val maxAmountInDay = 0
        val expected = "Превышен максимальный лимит суммы перевода ($maxLimitInMonthCard руб.) в месяц!"

        val result = resultCommisionVisaMir(
            amount = amount,
            maxAmountInMonth = maxAmountInMonth,
            maxAmountInDay = maxAmountInDay
        )
        assertEquals(expected, result)
    }

    @Test
    fun resultCommisionVisaMir_before_minBaseCommisionVisa() {
        val amount = 3_000
        val maxAmountInMonth = 0
        val maxAmountInDay = 0
        val expected = "Ваша комиссия с суммы $amount руб. составит $minBaseCommisionVisa руб."

        val result = resultCommisionVisaMir(
            amount = amount,
            maxAmountInMonth = maxAmountInMonth,
            maxAmountInDay = maxAmountInDay
        )
        assertEquals(expected, result)
    }

    @Test
    fun resultCommisionVisaMir_after_minBaseCommisionVisa() {
        val amount = 10_000
        val maxAmountInMonth = 0
        val maxAmountInDay = 0
        val expected = "Ваша комиссия с суммы $amount руб. составит " + "${amount * baseCommisionVisa} руб."

        val result = resultCommisionVisaMir(
            amount = amount,
            maxAmountInMonth = maxAmountInMonth,
            maxAmountInDay = maxAmountInDay
        )
        assertEquals(expected, result)
    }

    @Test
    fun resultCommisionVkPay_more_15_000() {
        val amount = 20_000
        val maxAmountInMonth = 0
        val expected = "Превышен лимит перевода ($maxLimitOnce руб. за 1 раз)!"

        val result = resultCommisionVkPay(
            amount = amount,
            maxAmountInMonth = maxAmountInMonth
        )
        assertEquals(expected, result)
    }

    @Test
    fun resultCommisionVkPay_more_40_000() {
        val amount = 1_000
        val maxAmountInMonth = 50_000
        val expected = "Превышен максимальный лимит суммы перевода ($maxLimitInMonthVkPay руб.) в месяц!"

        val result = resultCommisionVkPay(
            amount = amount,
            maxAmountInMonth = maxAmountInMonth
        )
        assertEquals(expected, result)
    }

    @Test
    fun resultCommisionVkPay_no_comission() {
        val amount = 1_000
        val maxAmountInMonth = 0
        val expected = "Коммисия за данный перевод остуствует"

        val result = resultCommisionVkPay(
            amount = amount,
            maxAmountInMonth = maxAmountInMonth
        )
        assertEquals(expected, result)
    }
}
