import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()

    val a = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    val b = br.readLine().split(" ").map { it.toInt() }.toMutableList()

    var sum = 0
    (0..<size).forEach { _ ->
        val minOfA = a.min()
        val maxOfB = b.max()
        sum += minOfA * maxOfB
        a.remove(minOfA)
        b.remove(maxOfB)
    }
    println(sum)
}