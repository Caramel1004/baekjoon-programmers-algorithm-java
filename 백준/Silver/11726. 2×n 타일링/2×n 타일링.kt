fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()

    val dp = IntArray(n + 1) { 0 }
    for(idx in 1..n) {
        dp[idx] = when(idx) {
            1 -> 1 % 10_007
            2 -> 2 % 10_007
            else -> (dp[idx - 1] + dp[idx - 2]) % 10_007
        }
    }
    print(dp[n])
}