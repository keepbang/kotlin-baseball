package org.keepbang.org.keepbang.baseball.utils

import org.keepbang.baseball.domain.MAX_RANGE


class ValidateUtils {
    companion object {
        const val VALID_REGEX = "[1-9]{$MAX_RANGE}"

        fun validation(numbers: String) {
            if (!numbers.matches(VALID_REGEX.toRegex())) {
                throw IllegalArgumentException("1부터 9까지의 숫자 ${MAX_RANGE}자리를 입력해주세요.")
            }
            if (isDuplicateNumbers(numbers)) {
                throw IllegalArgumentException("중복된 숫자가 입력되었습니다.")
            }
        }

        private fun isDuplicateNumbers(numbers: String): Boolean {
            val distinctSet: Set<Char> = HashSet(numbers.toCharArray().toSet())
            return distinctSet.size != MAX_RANGE
        }
    }
}