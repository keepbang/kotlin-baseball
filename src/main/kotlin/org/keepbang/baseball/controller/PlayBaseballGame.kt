package org.keepbang.baseball.controller

import org.keepbang.baseball.domain.Ball
import org.keepbang.baseball.domain.PlayerBall
import org.keepbang.org.keepbang.baseball.domain.Inning
import org.keepbang.org.keepbang.baseball.view.OutputView
import org.keepbang.org.keepbang.baseball.view.OutputView.Companion.enterNumber
import org.keepbang.org.keepbang.baseball.view.OutputView.Companion.inningResultOutput
import org.keepbang.util.Console

class PlayBaseballGame {

    var randomBall: Ball
        private set

    constructor(ball: Ball) {
        randomBall = ball
    }

    fun play() {
        var isEnd = false

        while (!isEnd) {
            isEnd = playGame()
        }
    }

    fun playGame(): Boolean {
        try {
            val playerBall = enterPlayerNumber()
            val inning = inningStart(playerBall)
            inningResultOutput(inning.score)
            return inning.isGameEnd()
        } catch (e: IllegalArgumentException) {
            OutputView.printError(e.message!!)
            return false
        }
    }

    private fun enterPlayerNumber(): PlayerBall {
        enterNumber()
        val input = Console.readLine()
        return PlayerBall.createPlayerBall(input)
    }

    private fun inningStart(playerBall: PlayerBall): Inning {
        val inning = Inning()
        inning.play(randomBall, playerBall)
        return inning
    }

}
