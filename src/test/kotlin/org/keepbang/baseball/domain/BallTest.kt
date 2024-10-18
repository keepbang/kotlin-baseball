package org.keepbang.baseball.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe


class BallTest : BehaviorSpec({

    Given("1,2,3,4,5가 담겨져있는 리스트가 존재함") {
        val list = listOf(1, 2, 3, 4, 5)

        When("리스트로 ball 생성") {
            val actual = Ball(list)

            Then("생성자가 생성됨") {
                actual.numbers shouldBe list
            }

        }
    }


})
