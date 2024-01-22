package lec09

/**
 * getter, setter 자동 생성
 */
class Person(name: String, age: Int) {
    val name: String = name
    var age: Int = age
}

class Person2(
    val name: String,
    var age: Int
) {
    init {
        if (age < 0)
            throw IllegalArgumentException("exception")
    }

    /**
     * 부 생성자는 지양하라
     */
    constructor(name: String) : this(name, 1) {
        println("부생성자 1")
    }

    constructor() : this("test") {
        println("부생성자 2")
    }
}

class Person3(
    name: String = "Test",
    var age: Int = 1
) {

    /**
     * backing field 를 사용하는 이유는 순환참조 때문
     * get 내부에서도 getter 를 계속 참조하기 때문에 (근데 이거 쓸일 없음 차라리 프로퍼티로 만들면 됨)
     * setter 도 마찬가지인데 setter 자체는 잘 안씀
     */
    val name: String = name
        get() = field.uppercase()

    // 얘를 쓰면 backing field 굳이 안써도 됨
    val upperName: String = this.name.uppercase()

    fun isAdult(): Boolean {
        return this.age >= 20
    }

    /**
     * Custom Getter (함수 대신 프로퍼티로 사용 가능)
     * 언제 써야하는가?
     * 객체의 속성을 나타내면 Custom Getter 아니면 함수
     */
    val isAdult: Boolean
        get() = this.age >= 20
}

/**
 * Converting 과정처럼 부생성자를 써야하는 경우에도 정적 팩토리 메소드 패턴으로 해결
 */
fun main() {
    var per1: Person2 = Person2("asd")
    println()
    var per2: Person2 = Person2()
}