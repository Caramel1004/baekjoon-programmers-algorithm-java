import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val loopCount = br.readLine().toInt()
    
    repeat(loopCount) { _ ->
        val names = mutableMapOf<String, String>()
        val types = mutableSetOf<String>()
        repeat(br.readLine().toInt()) { _ ->
            val st = StringTokenizer(br.readLine())
            val key = st.nextToken()
            val value = st.nextToken()
            types.add(value)
            names[key] = value
        }
        val caseCount = types
            .map { type -> names.count { it.value == type } + 1 }
            .fold(1) { acc, value -> (acc * value) } - 1
        sb.append(caseCount).append("\n")
    }
    print(sb)
}