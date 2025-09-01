fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    val size = br.readLine().toInt()

    repeat(size) {
        val num = br.readLine().toInt()
        sb.append(tribonacci(num)).append("\n")
    }
    print(sb)
}

private fun tribonacci(num: Int): Int = when (num) {
    3 -> 4
    2 -> 2
    1 -> 1
    else -> tribonacci(num - 1) + tribonacci(num - 2) + tribonacci(num - 3)
}