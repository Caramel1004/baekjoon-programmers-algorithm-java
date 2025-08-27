import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val st = StringTokenizer(br.readLine())

    val dogamCount = st.nextToken().toInt()
    val searchCount = st.nextToken().toInt()

    val mapOfPoketmons = mutableMapOf<String, Int>()
    val mapOfPoketmonsIndex = mutableMapOf<Int, String>()
    repeat(dogamCount) {
        val word = br.readLine()
        mapOfPoketmons[word] = it
        mapOfPoketmonsIndex[it] = word
    }
    repeat(searchCount) {
        val word = br.readLine()
        val typedValue = try {
            word.toInt()
        } catch(e: NumberFormatException) {
            word
        }
        when (typedValue) {
            is String -> sb.append(mapOfPoketmons[typedValue]?.plus(1) ?: -1).append('\n')
            is Int -> sb.append(mapOfPoketmonsIndex[typedValue - 1]).append('\n')
        }
    }
    print(sb)
}