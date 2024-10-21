package org.keepbang.baseball.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import org.keepbang.org.keepbang.baseball.domain.Inning

class InningTest: BehaviorSpec({

    Given("randomBall과 playerBall 생성") {
        forAll(
            row(Ball(listOf(1,2,3)), PlayerBall.createPlayerBall("456"), 0, 0),
            row(Ball(listOf(7,1,3)), PlayerBall.createPlayerBall("713"), 3, 0),
            row(Ball(listOf(5,8,9)), PlayerBall.createPlayerBall("597"), 1, 1),
            row(Ball(listOf(5,8,9)), PlayerBall.createPlayerBall("859"), 1, 2)
        ) { randomBall, playerBall, strike, ball ->
            When("생성된 볼로 게임 진행") {
                val inning = Inning()
                inning.play(randomBall, playerBall)

                Then("게임에 따른 결과") {
                    inning.score.strike shouldBe strike
                    inning.score.ball shouldBe ball
                }
            }
        }
    }

})