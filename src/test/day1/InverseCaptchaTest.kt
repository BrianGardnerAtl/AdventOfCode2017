package day1

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class InverseCaptchaTest {

    val inverseCaptcha = InverseCaptcha()

    // Test the next digit captcha method
    @Test
    fun itHandlesACaptchaWithTwoMatchingSequences() {
        val input = "1122"
        val expectedOutput = 3
        assertNextDigitInputProducesExpectedOutput(input, expectedOutput)
    }

    @Test
    fun itHandlesACaptchaWithAllDigitsTheSame() {
        val input = "1111"
        val expectedOutput = 4
        assertNextDigitInputProducesExpectedOutput(input, expectedOutput)
    }

    @Test
    fun itHandlesACaptchaWithAllDifferentDigits() {
        val input = "1234"
        val expectedOutput = 0
        assertNextDigitInputProducesExpectedOutput(input, expectedOutput)
    }

    @Test
    fun itHandlesACaptchaWhenOnlyTheFirstAndLastDigitMatch() {
        val input = "91212129"
        val expectedOutput = 9
        assertNextDigitInputProducesExpectedOutput(input, expectedOutput)
    }

    private fun assertNextDigitInputProducesExpectedOutput(input : String, output : Int) {
        assertThat(inverseCaptcha.calculateNextDigitCaptcha(input), equalTo(output))
    }

    // Test the halfway around captcha method
    @Test
    fun itHandlesACaptchaWhenAllDigitsMatchTheHalfwayAroundDigit() {
        val input = "1212"
        val expectedOutput = 6
        assertHalfwayAroundDigitInputProducesExpectedOutput(input, expectedOutput)
    }

    @Test
    fun itHandlesACaptchaWhenNoneOfTheDigitsMatchTheHalfwayAroundDigit() {
        val input = "1221"
        val expectedOutput = 0
        assertHalfwayAroundDigitInputProducesExpectedOutput(input, expectedOutput)
    }

    @Test
    fun itHandlesACaptchaWhenOnlyOneOfTheDigitsMatchTheHalfwayAroundDigit() {
        val input = "123425"
        val expectedOutput = 4
        assertHalfwayAroundDigitInputProducesExpectedOutput(input, expectedOutput)
    }

    @Test
    fun itHandlesOtherCaptchas() {
        val firstInput = "123123"
        val firstOutput = 12
        assertHalfwayAroundDigitInputProducesExpectedOutput(firstInput, firstOutput)

        val secondInput = "12131415"
        val secondOutput = 4
        assertHalfwayAroundDigitInputProducesExpectedOutput(secondInput, secondOutput)
    }

    private fun assertHalfwayAroundDigitInputProducesExpectedOutput(input : String, output : Int) {
        assertThat(inverseCaptcha.calculateHalfwayAroundDigitCaptcha(input), equalTo(output))
    }
}