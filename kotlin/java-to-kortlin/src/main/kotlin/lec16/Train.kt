package lec16

open class Train {
}

fun Train.isExpensive(): Boolean {
    println("Train")
    return true
}

class Srt : Train() {
}

fun Srt.isExpensive(): Boolean {
    println("Srt")
    return true
}

fun main() {
    // 확장 함수끼리 오버라이드를 해도 현재 타입의 확장함수를 호출한다
    val train: Train = Train()
    train.isExpensive()

    val train2: Train = Srt()
    train2.isExpensive()

    val srt: Srt = Srt()
    srt.isExpensive()


}