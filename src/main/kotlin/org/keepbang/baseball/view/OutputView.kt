package org.keepbang.org.keepbang.baseball.view

import org.keepbang.org.keepbang.baseball.domain.Score

class OutputView {
    companion object {
        fun enterNumber() {
            print("숫자를 입력해주세요 : ")
        }

        fun gameEndOutput() {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 끝")
        }

        fun gameRetryAnswer() {
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        }

        fun printError(errorMessage: String) {
            println("[ERROR] $errorMessage")
        }

        fun inningResultOutput(score: Score) {
            val strike: Int = score.strike
            val ball: Int = score.ball
            val strikeResult = strikeFormatting(strike)
            val ballResult = ballFormatting(ball)
            val nothingResult = nothingFormatting(strike, ball)
            println("$strikeResult $ballResult $nothingResult")
        }

        private fun strikeFormatting(strike: Int): String {
            if (strike > 0) {
                return "$strike 스트라이크 "
            }
            return ""
        }

        private fun ballFormatting(ball: Int): String {
            if (ball > 0) {
                return "$ball 볼 "
            }
            return ""
        }

        private fun nothingFormatting(strike: Int, ball: Int): String {
            if (strike == 0 && ball == 0) {
                return "낫싱"
            }
            return ""
        }
    }
}