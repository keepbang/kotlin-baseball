package org.keepbang.util

import java.util.*

/**
 * 콘솔 출력용
 */
class Console {

    companion object {
        var scanner: Scanner = getScanner()
            private set

        fun readLine(): String {
            return scanner.nextLine()
        }
    }
}

private fun getScanner(): Scanner {
    return Scanner(System.`in`) // in은 코틀린에서 사용하는 예약어라서 ``로 감싸서 사용한다.
}