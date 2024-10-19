package org.keepbang.baseball.utils

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.shouldForAll
import org.keepbang.baseball.domain.MAX_RANGE
import org.keepbang.org.keepbang.baseball.utils.ValidateUtils.Companion.validation

class ValidateUtilsTest: StringSpec({

    "입력숫자_검증_성공" {
        listOf(
            "123", "456", "789"
        ).shouldForAll {
            shouldNotThrow<Exception> {
                validation(it)
            }
        }
    }

    "입력숫자 검증 실패 (숫자/3자릿수 실패 테스트)" {
        listOf(
            "1", "12", "1234", " ", "   ", "    ",
            "a1", "as2", "f12", "-1", "+34", "abc",
            "1 2", " 45", "67 ", "968-231", "12+345","000","0"
        ).shouldForAll {
            shouldThrowWithMessage<IllegalArgumentException>(
                "1부터 9까지의 숫자 ${MAX_RANGE}자리를 입력해주세요."
            ) {
                validation(it)
            }
        }
    }

    "중복숫자 검증 실패 (숫자/3자릿수 실패 테스트)" {
        listOf(
            "111","222","999"
        ).shouldForAll {
            shouldThrowWithMessage<IllegalArgumentException>(
                "중복된 숫자가 입력되었습니다."
            ) {
                validation(it)
            }
        }
    }

})