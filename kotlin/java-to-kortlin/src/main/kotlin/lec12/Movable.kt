package lec12

interface Movable {

    fun move()
    fun fly()
}

private fun moveSomething(move: Movable) {
    move.move()
    move.fly()
}

fun main() {
    moveSomething(object : Movable {
        override fun move() {
            println("움직인다,")
        }

        override fun fly() {
            println("난다")
        }

    })
}