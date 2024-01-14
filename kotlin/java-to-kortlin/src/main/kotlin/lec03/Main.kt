package lec03

import lec02.Person

fun main() {
    val number: Int = 3;
    // kotlin 은 반드시 명시적 형변환 필요
//    val number2: Long = number; // compile error
    val number2: Long = number.toLong()

    val number3: Int? = 3;
    val number4: Long = number3?.toLong() ?: 0
}

// type casting
fun casting(obj: Any) {
    if (obj is Person) {
        val person = obj as Person
        println(person.name)

        // smart cast
        println(obj.name)
    }

    // not
    if (obj !is Person) {

    }
}


fun casting(obj: Any?) {
    // safe casting
    val person = obj as? Person;
    println(person?.name);
}