package org.keepbang.util

import java.lang.reflect.Field
import java.util.*

/**
 * 콘솔 출력용
 */

private var scanner: Scanner = getScanner()

private fun getScanner(): Scanner {
    return Scanner(System.`in`) // in은 코틀린에서 사용하는 예약어라서 ``로 감싸서 사용한다.
}

private fun scannerIsClosed(): Boolean {
    try {
        val sourceClosedField: Field = Scanner::class.java.getDeclaredField("sourceClosed")
        sourceClosedField.setAccessible(true)
        return sourceClosedField.getBoolean(scanner)
    } catch (e: NoSuchFieldException) {
        println("리플렉션 중 에러 발생")
    } catch (e: IllegalAccessException) {
        println("리플렉션 중 에러 발생")
    }
    return true
}

private fun makeNewScannerIfScannerIsClosed() {
    if (scannerIsClosed()) {
        scanner = getScanner()
    }
}