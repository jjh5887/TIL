package lec04

fun main() {
    val str1: String = "123"
    val str2: String = str1
    val str3: String = "123"

    // === -> ==
    // == -> equals
    println(str1 === str2) // true
    println(str2 == str3) // true 예시가 string이라 의미가 없음
    // >, < -> compareTo
    println(str1 > str2)

}