package lec05


fun validate(score: Int) {
    if (score < 0) {
        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
    }
}

// kotlin 에서 if-else 문은 expression (if else-if else 도 마찬가지)
fun validate2(score: Int): String {
    return if (score >= 50) {
        "P"
    } else {
        "F"
    }
}

// in
fun validate3(score: Int) {
    if (score !in 0..100) {
        throw IllegalArgumentException("${score}범위는 0 부터 100")
    }
}

// when (switch 대신)
fun validate4(score: Int): String {
    return when (score / 10) {
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "D"
    }
}

fun validate5(score: Int): String {
    return when (score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

fun validate6(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

fun validate7(number: Int) {
    when (number) {
        1, 0, -1 -> println("어디서 본 숫자")
        else -> println("0, 1, -1 아니래")
    }
}


fun validate8(number: Int) {
    when {
        number == 0 -> println("0이래")
        number % 2 == 0 -> println("짝수래")
        else -> println("홀수래")
    }
}
