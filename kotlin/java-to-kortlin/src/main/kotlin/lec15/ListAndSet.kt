package lec15

/**
 * 기본적으로 List 와 Set 은 사용법 동일
 */
fun main() {
    // 불변
    val list = listOf(100 ,200)
    println(list[0])

    // 가변
    val list2 = mutableListOf(100, 200)
    list2.add(300)

    val emptyList = emptyList<Int>()

    // 타입 추론
    printNumbers(emptyList())
}

fun printNumbers(list: List<Int>) {
    for (data in list) {
        println(data)
    }

    for((index, value) in list.withIndex()) {
        println("$index $value")
    }

}
