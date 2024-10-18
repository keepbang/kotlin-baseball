package org.keepbang.baseball.controller

import org.keepbang.baseball.type.GameStatus

/**
 * 게임 플레이를 위한 컨트롤러
 */
class BaseballGame {
    private var gameStatus = GameStatus.RESTART

    fun start() {
        while (!gameStatus.isEnd()) { // 종료 상태가 아니면 계속 실행

        }
    }
}