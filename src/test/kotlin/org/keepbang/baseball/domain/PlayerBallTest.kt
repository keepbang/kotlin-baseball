package org.keepbang.baseball.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.shouldBe

class PlayerBallTest : FunSpec({

    test("볼 생성 성공 테스트") {
        forAll(
            row("123", listOf(1, 2, 3)),
            row("456", listOf(4, 5, 6)),
            row("789", listOf(7, 8, 9))
        ) { input, expected ->
            val playerBall = PlayerBall.createPlayerBall(input)
            playerBall.numbers shouldBe expected
        }
    }

    test("볼생성 실패 테스트") {
        val inputList = listOf(
            "0", "000", "", " ", "   ",
            "1111", "1000", "9999",
            "+0", "-99", "_",
            "123abcd", "abc", "ab3",
            "123-12", "11 ", "1 9", " 12",
            " 342", "123 ", "111", "999"
        )

        inputList.shouldForAll {
            shouldThrow<IllegalArgumentException> {
                PlayerBall.createPlayerBall(it)
            }
        }
    }

})