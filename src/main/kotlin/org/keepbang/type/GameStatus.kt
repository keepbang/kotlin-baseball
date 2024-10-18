package org.keepbang.org.keepbang.type

enum class GameStatus(val gameStatus: String) {
    RESTART("1"),
    END("2"),
    ERROR("0");

    fun isEnd(): Boolean{
        return this == END;
    }

    fun isNotError(): Boolean {
        return this != ERROR;
    }
}