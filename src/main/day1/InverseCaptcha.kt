package day1

class InverseCaptcha {
    fun calculateNextDigitCaptcha(input : String) : Int {
        var sum = 0

        val digits = input.asIterable()
                .map { it.toString().toInt() }

        val lastIndex = digits.size - 1

        digits.forEachIndexed { index, digit ->
            sum += if (index == 0) {
                // compare first and last values
                captchaCompare(digit, digits[lastIndex])
            } else {
                captchaCompare(digit, digits[index-1])
            }
        }

        return sum
    }

    private fun captchaCompare(first : Int, second : Int) : Int {
        return if (first == second) {
            first
        } else {
            0
        }
    }
}