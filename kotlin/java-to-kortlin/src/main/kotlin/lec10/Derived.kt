package lec10

class Derived(
    override val number: Int
) : Base(number) {

    init {
        println("Derived Class")
    }
}

fun main() {
    var derived = Derived(500)
}