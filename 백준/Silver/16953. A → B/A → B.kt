import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val initial = st.nextToken().toInt()
    var currentValue = st.nextToken().toInt()
    var stepCount = 0

    while (currentValue > initial) {
        currentValue = if (currentValue % 2 == 0) {
            currentValue shr 1
        } else if(currentValue % 10 == 1) {
            (currentValue - 1) / 10
        } else {
            -1
        }
        stepCount++
    }
    println(if(initial == currentValue) { stepCount + 1 } else { -1 })
}