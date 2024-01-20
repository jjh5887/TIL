package lec08


/**
 * block 대신 = 사용 가능, 타입 생략 가능
 * 단 = 을 사용하지 않고 {} 를 사용한다면 return 명시 필수
 */
fun max(a: Int, b: Int) = if (a > b) a else b


/**
 * default parameter
 */
fun repeat(str: String, num: Int = 3, useNewLine: Boolean = true) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

fun main() {
    // named argument, 자바 함수를 가져와서 쓸 때는 사용 불가능
    repeat("Hi", useNewLine = false)

    printAll("A", "B", "C")

    val array = arrayOf("A", "B", "C")
    // spread 연산자
    printAll(*array)
}

fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}
