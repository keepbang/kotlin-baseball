package org.keepbang.org.keepbang.baseball

import org.keepbang.baseball.controller.BaseballGame

class BaseballApplication {

    companion object {
        fun main() {
            val baseballGame = BaseballGame()
            baseballGame.start()
        }
    }
}