import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()

    // 1. 큐에 offer
    val size = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val deque = ArrayDeque<Int>()
    for (i in 0..<size) {
        deque += st.nextToken().toInt()
    }
    
    // 2. key: 제공된 정수, value: 정수의 갯수 
    val map = HashMap<Int, Int>()
    while (deque.isNotEmpty()) {
        val key = deque.removeFirst()
        map[key] = map.getOrDefault(key, 0) + 1
    }

    br.readLine() // M
    // 3. key에 대응되는 value들을 문자열로 치환 
    val result = br.readLine()
        .splitToSequence(" ")
        .joinToString(" ") { if(it.toInt() in map) map[it.toInt()].toString() else "0" }

    print(result)
}