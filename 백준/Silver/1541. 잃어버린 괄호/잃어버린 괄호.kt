import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine(), "+-", true)

    val deque = ArrayDeque<String>()
    while (st.hasMoreTokens()) {
        deque.addLast(st.nextToken())
    }

    var min = 0
    while (!deque.isEmpty()) {
        if(deque[0] == "-") {
            deque.removeFirst()
            while (deque.isNotEmpty() && deque[0] != "-") {
                val polledElement = deque.removeFirst()
                if(polledElement != "+") {
                    min -= polledElement.toInt()
                }
            }
        } else if(deque[0] == "+") {
            deque.removeFirst()
        } else {
            min += deque.removeFirst().toInt()
        }
    }
    println(min)
}