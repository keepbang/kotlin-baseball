package org.keepbang.baseball.domain

import org.keepbang.org.keepbang.baseball.utils.ValidateUtils

const val MAX_RANGE: Int = 3

class PlayerBall private constructor(numbers: List<Int>): Ball(numbers) {
    companion object {
        fun createPlayerBall(input: String): PlayerBall {
            ValidateUtils.validation(input)
            val numbers: ArrayList<Int> = ArrayList()

            for (i in 0 until MAX_RANGE) { // 0 < MAX_RANGE
                numbers.add(Character.getNumericValue(input[i]))
            }
            return PlayerBall(numbers)
        }
    }
}