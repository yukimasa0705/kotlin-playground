// 命令型でわかりやすく書かれた素数表示プログラム
// 入力された正の整数 N 以下の素数をすべて表示する

import kotlin.math.sqrt

fun isPrime(n: Int): Boolean {
    // 2 未満は素数ではない
    if (n < 2) return false
    // 試し割りは sqrt(n) までで十分
    val limit = sqrt(n.toDouble()).toInt()
    for (i in 2..limit) {
        if (n % i == 0) return false
    }
    return true
}

fun main() {
    // ユーザーに入力を促す（対話的に使う想定）
    print("整数を入力してください（例: 30）: ")
    val line = readLine()
    val n = line?.toIntOrNull()
    if (n == null) {
        println("入力が整数ではありません。")
        return
    }
    if (n < 2) {
        println("2 以上の整数を入力してください。")
        return
    }

    var primes = mutableListOf<Int>()
    var i = 2
    while (i <= n) {
        if (isPrime(i)) {
            primes.add(i)
        }
        i++
    }

    // 出力例: 2 3 5 7 11 ...
    println(primes.joinToString(" "))
}
