package lec11

val NUM  = 10

fun add(a: Int, b: Int): Int {
    return a + b
}


/**
 * 생성자에 접근지시어 쓰려면 constructor 생략 불가능
 */
open class Cat protected constructor(){

}