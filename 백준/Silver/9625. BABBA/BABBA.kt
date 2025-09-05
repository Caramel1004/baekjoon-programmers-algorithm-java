fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    val clickCnt = br.readLine().toInt()

    // first: A, second: B
    val dp = Array(clickCnt + 1) { 0 to 0 }
    dp[1] = 0 to 1
    for (i in 2..clickCnt) {
        dp[i] = if (i == 2) {
            1 to 1
        } else {
            (dp[i - 1].first + dp[i - 2].first) to (dp[i - 1].second + dp[i - 2].second)
        }
    }
    sb.append(dp[clickCnt].first)
        .append(" ")
        .append(dp[clickCnt].second)
    print(sb)
}