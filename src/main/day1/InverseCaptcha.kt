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

    fun calculateHalfwayAroundDigitCaptcha(input : String) : Int {
        var sum = 0

        val digits = input.asIterable()
                .map { it.toString().toInt() }

        val size = digits.size
        val halfway = digits.size / 2

        digits.forEachIndexed { index, digit ->
            val halfwayIndex = (index + halfway) % size
            sum += captchaCompare(digit, digits[halfwayIndex])
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