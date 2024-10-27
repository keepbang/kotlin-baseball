package org.keepbang.org.keepbang.baseball.domain

import org.keepbang.org.keepbang.baseball.type.ScoreType

data class Score(
    private var _strike: Int = 0,
    private var _ball: Int = 0
) {

    val strike: Int
        get() = this._strike

    val ball: Int
        get() = this._ball

    fun addStrike() {
        this._strike++
    }

    fun addBall() {
        this._ball++
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