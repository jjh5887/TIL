package lec19

// data class 는 componentN 함수를 자동으로 만들어줌
data class Person(
    val name: String,
    val age: Int,
)


// componentN 직접 구현
class Person2(
    val name: String,
    val age: Int,
) {
    // 연산자의 속성을 가져서 operator 붙여야함
    operator fun component1(): String {
        return this.name;
    }

    operator fun component2(): Int {
        return this.age;
    }
}

fun main() {
    val person = Person("test", 20)
    // 구조 분해 (react 하면서 본거 같은데)
    val (name, age) = person

    // 구조분해는 사실상 componentN 함수를 이용한것
    val name1 = person.component1()
    val age1 = person.component2()

    val map = mapOf(1 to "test", 2 to "test2")

    // entries 도 구조 문법
    for ((key, value) in map.entries) {

    }
}