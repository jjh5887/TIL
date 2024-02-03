package lec16


fun main() {
    val str = "ABC"
    println(str.lastChar())
}

/**
 * 화장함수가 캡슐화를 깨트릴 수 있다고 생각할 수 있지만
 * private, protected 멤버는 가져올 수 없음
 */
fun String.lastChar(): Char {
    return this[this.length - 1]
}


/**
 * 확장 함수가 멤버함수를 오버라이드 해도 멤버함수가 호출됨!
 */
fun String.compareTo(other: String): Int {
    return 0
}
