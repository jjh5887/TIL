package lec10

open class Base (
    open val number: Int = 100
) {
    init {
        println("Base Class")
        /**
         * 상위 클래스를 설계할 때
         * 생성자 또는 초기화를 블록에 사용되는 프로퍼티에는 open 을 피해야 한다!
         */
        println(number)
    }
}