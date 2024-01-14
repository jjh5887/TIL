package lec02


fun main() {

    val str: String? = null;
    // safe call
    println(str?.length);

    // elvis
    println(str?.length ?: 0);

    // kotlin 에서 자바 코드르 쓰려는 경우?
    // platform type
    val person = Person("개발자")
    // java 의 Nullable, NotNull 어노테이션 인식
    startsWithA8(person.name)

}

// java style
fun startsWithA1(str: String?): Boolean {
    if (str == null) {
        throw IllegalArgumentException("null");
    }

    return str.startsWith("A");
}

// java style
fun startsWithA2(str: String?): Boolean? {
    if (str == null) {
        return null;
    }

    return str.startsWith("A")
}

// java style
fun startsWithA3(str: String?): Boolean {
    // non-safe npe
//    return str.startsWith("A"); // compile error

    if (str == null) {
        return false
    }

    return str.startsWith("A")
}


// kotlin style
fun startsWithA4(str: String?): Boolean {
    return str?.startsWith("A")
        ?: throw java.lang.IllegalArgumentException("null")
}

// kotlin style
fun startsWithA5(str: String?): Boolean? {
    return str?.startsWith("A");
}

// kotlin style
fun startsWithA6(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}


// early return
fun calculate(number: Long?): Long{
    number ?: return 0

    // 위와 같은 의미
//    if(number == null) {
//        return 0;
//    }

    return number + 1
}

// !! is never null
fun startsWithA7(str: String?): Boolean {
    // null 이 들어오면 npe 터짐
    return str!!.startsWith("A")
}

fun startsWithA8(str: String): Boolean {
    return str.startsWith("A")
}