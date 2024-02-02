package lec14

import lec14.Country.AMERICA
import lec14.Country.KOREA

fun main() {
    val person = PersonDto("test", 100)
    val person2 = PersonDto("test", 100)

    println(person == person2)
    println(person === person2)
    println(person)

}

data class PersonDto(
    val name: String,
    val age: Int
)

fun handleCountry(country: Country) {
    // else 필요 없음
    when (country) {
        KOREA -> TODO()
        AMERICA -> TODO()
    }
}

enum class Country(
    private val code: String,
) {
    KOREA("01"),
    AMERICA("02")
    ;
}


sealed class HyundaiCar(
    val name: String,
    val price: Int,
)

fun handleCar(car: HyundaiCar) {
    // else 필요 없음
    when (car) {
        is Avante -> TODO()
        is Grandeur -> TODO()
        is Sonata -> TODO()
    }
}

/**
 * 컴파일 타임에 하위타입들을 기억한 (+런타임때 하위타입 추가 불가능)
 */
class Avante : HyundaiCar("아반떼", 3000)
class Sonata : HyundaiCar("소나타", 4000)
class Grandeur : HyundaiCar("그랜져", 5000)