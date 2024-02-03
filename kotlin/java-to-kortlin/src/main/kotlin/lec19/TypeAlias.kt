package lec19

import lec17.Fruit

typealias FruitFilter = (Fruit) -> Boolean

fun filterFruits(fruit: Fruit, filter: FruitFilter) {

}

data class UltraSuperGuardianTribe(
    val name: String
)

typealias USTGMap = Map<String, UltraSuperGuardianTribe>