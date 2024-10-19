package org.keepbang.org.keepbang.baseball.domain

import org.keepbang.org.keepbang.baseball.type.ScoreType

class Score {
    var strike: Int
        private set
    var ball: Int
        private set

    constructor(strike: Int, ball: Int) {
        this.strike = strike
        this.ball = ball
    }

    fun addStrike() {
        this.strike++
    }

    fun addBall() {
        this.ball++
    }

    fun refereeScore(scoreType: ScoreType) {
        if (scoreType.isStrike()) {
            this.addStrike()
        }
        if (scoreType.isBall()) {
            this.addBall()
        }
    }
}