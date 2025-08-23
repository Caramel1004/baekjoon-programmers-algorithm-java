import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    var st = StringTokenizer(br.readLine())

    val size = st.nextToken().toInt()
    val loopCount = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val nums = (0..<size).map { st.nextToken().toInt() }
    var prefixSum = 0
    val accSums = nums.map {
        prefixSum += it
        prefixSum
    }

    for (i in 0..<loopCount) {
        st = StringTokenizer(br.readLine())
        val startIndex = st.nextToken().toInt() - 1
        val endIndex = st.nextToken().toInt() - 1
        val startValue = if(startIndex - 1 < 0) { 0 } else { accSums[startIndex - 1] }
        sb.append(accSums[endIndex] - startValue).append("\n")
    }
    print(sb)
}