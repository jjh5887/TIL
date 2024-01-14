package lec01.Main

fun main() {

    // 기본적으로 연산시에  primitive
    var num: Long = 10L
    // final
    val num2: Long = 20L

    println(num)

    var num3: Long;
    num3 = 20L;
    num3 = 50;

    val num4: Long;
    num4 = 20;

    // val 는 변수 할당 1회만 가능
    //    num4 = 15; // error

    // new 키워드 사용 X
    var person = Person("kwjung")
}