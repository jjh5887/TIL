package lec10

class Penguin(
    species: String
) : Animal(species, 2), Flyable, Swimmable {

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 걷는다")
    }

    override val legCount: Int
        get() = super.legCount + this.wingCount

    override fun act() {
        super<Flyable>.act()
        super<Swimmable>.act()
    }

    override val swimmablity: Int
        get() = 3
}