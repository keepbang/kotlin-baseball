package org.keepbang.baseball.controller

import org.keepbang.baseball.type.GameStatus
import org.keepbang.baseball.utils.RandomGenerator
import org.keepbang.org.keepbang.baseball.view.OutputView.Companion.gameEndOutput
import org.keepbang.org.keepbang.baseball.view.OutputView.Companion.gameRetryAnswer
import org.keepbang.org.keepbang.baseball.view.OutputView.Companion.printError
import org.keepbang.util.Console

/**
 * 게임 플레이를 위한 컨트롤러
 */
class BaseballGame {
    private var gameStatus = GameStatus.RESTART

    fun start() {
        while (!gameStatus.isEnd()) { // 종료 상태가 아니면 계속 실행
            val randomPlayerBall = RandomGenerator.getRandomPlayerBall()

            val playBaseballGame = PlayBaseballGame(randomPlayerBall)
            playBaseballGame.play()
            gameEndOutput()
            gameStatus = getGameEndAnswer()
        }
    }

    private fun getGameEndAnswer(): GameStatus {
        var status = GameStatus.ERROR
        while(!status.isNotError()) {
            gameRetryAnswer()
            val input = Console.readLine()
            status = getGameStatusByAnswer(input)
        }

        return status
    }

    private fun getGameStatusByAnswer(input: String): GameStatus {
        if (!input.matches("[1,2]".toRegex())) {
            printError("잘못 입력했습니다.")
            return GameStatus.ERROR
        }
        if ("1" == input) {
            return GameStatus.RESTART
        }
        return GameStatus.END
    }


}