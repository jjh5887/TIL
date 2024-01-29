package lec12


fun main() {
    println(Singleton.a)
    Singleton.a += 10
    println(Singleton.a)
}

class Person private constructor(
    var name: String,
    var age: Int
) {

    /**
     * 동반 객체도 하나의 객체 취급해서 이름도 가질 수 있고 인터페이스도 구현 가능
     */
    companion object Factory : Log {
        private const val MIN_AGE = 1
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        override fun log() {
            println("구현")
        }

    }
}


/**
 * 싱글톤 패턴
 */
object Singleton {
    var a = 0
}