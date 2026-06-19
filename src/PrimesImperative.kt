// 関数型で書かれた素数表示プログラム
// 入力された正の整数 N 以下の素数をすべて表示する

import kotlin.math.sqrt

fun isPrime(n: Int): Boolean =
    n >= 2 && (2..sqrt(n.toDouble()).toInt()).none { n % it == 0 }

tailrec fun readValidInteger(): Int {
    print("整数を入力してください（例: 30）: ")
    val n = readIntOrNull()
    return when {
        n == null -> {
            println("正しい整数を入力してください。")
            readValidInteger()
        }
        n < 2 -> {
            println("2 以上の整数を入力してください。")
            readValidInteger()
        }
        else -> n
    }
}

fun readIntOrNull(): Int? = readLine()?.toIntOrNull()

fun main() {
    val n = readValidInteger()
    val primes = (2..n).filter(::isPrime)
    println(primes.joinToString(" "))
}
