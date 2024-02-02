package lec13


/**
 * kotlin 에서 중첩클래스는 기본적으로 static
 * effective java 에서도 중첩 클래스는 static 을 사용하라고함
 * (바깥 클래스를 참조 할 수 있어서 메모리 누수 문제가 생길 수 있음)
 */
class House(
    private val address: String,
    private val livingRoom: LivingRoom
) {
    class LivingRoom(
        private val area: Double
    )
}

/**
 * 권장되지 않는 내부 클래스
 */
class House2(
    private val address: String,
    private val livingRoom: LivingRoom2
) {
    inner class LivingRoom2(
        private val area: Double
    ) {
        val address: String
            get() = this@House2.address
    }
}