package org.keepbang.baseball.utils

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.keepbang.baseball.domain.Ball
import org.keepbang.baseball.domain.MAX_RANGE

class RandomGeneratorKtTest : StringSpec({

    "RandomGenerator 생성 성공" {
        val randomPlayerBall: Ball = RandomGenerator.getRandomPlayerBall()
        randomPlayerBall.numbers.size shouldBe MAX_RANGE
    }

})