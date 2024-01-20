package lec06

fun main() {

    // for-each
    val numbers = listOf(1L, 2L, 3L)
    for (num in numbers) {
        println(num)
    }

    for (i in 1..3) {
        println(i)
    }

    for (i in 3 downTo 1) {
        println(i)
    }

    // 2씩 올란간다
    for (i in 1..5 step 2) {
        println(i)
    }

}