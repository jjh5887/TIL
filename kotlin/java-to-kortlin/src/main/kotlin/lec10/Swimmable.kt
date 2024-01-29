package lec10

interface Swimmable {

    val swimmablity: Int
        get() = 3

    fun act() {
        println("어푸 어푸")
        println(swimmablity)
    }
}