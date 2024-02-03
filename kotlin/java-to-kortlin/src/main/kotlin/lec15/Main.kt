package lec15

fun main() {
    val array = arrayOf(100, 200)

    for (i in array.indices) {
        println("$i ${array[i]}")
    }
    println()

    for (i in array.withIndex()) {
        println("${i.index} ${i.value}")
    }
    println()

    // 배열이지만 그냥 추가도 가능
    val plus = array.plus(300)

    for ((index, value) in plus.withIndex()) {
        println("$index $value")
    }

}