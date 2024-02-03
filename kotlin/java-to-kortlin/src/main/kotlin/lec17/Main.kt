package lec17


class Fruit(
    val name: String,
    val price: Int,
)

fun main() {
    val fruits = listOf(
        Fruit("사과", 500),
        Fruit("사과", 1500),
        Fruit("사과", 2500),
        Fruit("바나나", 500),
        Fruit("바나나", 2500),
        Fruit("바나나", 3500),
        Fruit("수박", 5000),
    )

    // 람다 만드는법
    // 람다도 타입이 있음
    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    // 람다 만드는법 2
    val isApple2: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과" }

    isApple(fruits[0])
    isApple.invoke(fruits[1])

    filterFruits(fruits, isApple2)
    filterFruits(fruits, { fruit: Fruit -> fruit.name == "사과" })

    // 가독성을 위해서 {} 부분은 뺄 수 있음
    filterFruits(fruits) { fruit: Fruit -> fruit.name == "사과" }

    // 타입 추론 가능
    filterFruits(fruits) { fruit -> fruit.name == "사과" }

    // 인자가 한개이면 it 으로 대체 가능
    filterFruits(fruits) { it.name == "사과" }

    var str = "Test"
    str = "Test 222"

    // java 에서는 lambda 에서는 final 변수만 사용 가능하지만
    // kotlin 에서는 closure 를 사용하여 가능
    val isTest = { fruit: Fruit -> fruit.name == str }


}

private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    val result = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) {
            result.add(fruit)
        }
    }

    return result
}

