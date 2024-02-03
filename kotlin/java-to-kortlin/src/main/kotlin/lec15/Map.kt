package lec15

fun main() {
    val oldMap = mutableMapOf<Int, String>()
    oldMap[1] = "Monday"
    oldMap[2] = "Tuesday"

    val map = mapOf(1 to "Monday", 2 to "Tuesday")

    for (key in map.keys) {
        println(key)
        println(map[key])
    }

    for ((key, value) in map.entries) {
        println("$key $value")
    }


}