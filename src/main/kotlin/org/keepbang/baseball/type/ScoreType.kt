package org.keepbang.org.keepbang.baseball.type

enum class ScoreType {
    STRIKE, BALL, NOTHING;

    fun isStrike(): Boolean {
        return this == STRIKE
    }

    fun isBall(): Boolean {
        return this == BALL
    }
}