package org.keepbang.org.keepbang.baseball.domain

import org.keepbang.baseball.domain.Ball
import org.keepbang.baseball.domain.MAX_RANGE
import org.keepbang.org.keepbang.baseball.type.ScoreType

class Inning {
    var score: Score
        private set

    constructor() {
        score = Score(0, 0)
    }

    fun play(randomBall: Ball, playerBall: Ball) {
        val randomNumbers: List<Int> = randomBall.numbers
        for (i in 0 until randomNumbers.size) {
            val randomNumber = randomNumbers.get(i)
            val scoreType: ScoreType = refereePlay(playerBall, randomNumber, i)
            score.refereeScore(scoreType)
        }
    }

    private fun refereePlay(playerBall: Ball, randomNumber: Int, i: Int): ScoreType {
        val playerNumbers = playerBall.numbers
        if (playerNumbers.get(i) == randomNumber) {
            return ScoreType.STRIKE
        }
        if (playerNumbers.contains(randomNumber)) {
            return ScoreType.BALL
        }
        return ScoreType.NOTHING
    }

    fun isGameEnd(): Boolean {
        return score.strike == MAX_RANGE
    }
}