package lec07

import java.io.BufferedReader
import java.io.FileReader

fun paresInt(str: String): Int {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 ${str}은 숫자가 아닙니다.")
    }
}

// try-catch-finally 완전히 동일
fun paresInt2(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

/**
 * kotlin 에서는 try-with-resource 없음
 * 대신 use 라는 확장 함수 이용
 */
fun readFile(path: String) {
    BufferedReader(FileReader(path)).use { reader ->
        println(reader.readLine())
    }
}