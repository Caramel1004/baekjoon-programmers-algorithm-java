import java.io.BufferedReader
import java.io.StringReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val loopCount = br.readLine().toInt()
    // loop scope
    for(i in 0..< loopCount) {
        var st = StringTokenizer(br.readLine());
        val docCount = st.nextToken().toInt()
        val targetKey = st.nextToken().toInt()

        // ex) deque: [{0,1}, {1, 1}, {2, 9}, {3, 1}, {4, 1} , {5, 1}]
        val deque = ArrayDeque<Pair<Int, Int>>()
        var order = 0;

        // 입력 받은 문서 갯수만큼 우선 순위 푸쉬
        st = StringTokenizer(br.readLine());
        repeat(docCount) { key ->
            val importance = st.nextToken().toInt()
            deque.addLast(key to importance)
        }

        val targetPair = deque[targetKey]
        var max = deque.maxOf { it.second }
        while(!deque.isEmpty() && deque.contains(targetPair)) {
            val pair = deque[0]
            val peekValue = pair.second
            if(peekValue >= max){
                deque.removeFirst()
                order++
                max = if(deque.isNotEmpty()) { deque.maxOf { it.second } } else { max }
            } else {
                deque.addLast(deque.removeFirst());
            }
        }
        sb.append(order).append("\n");
    }
    print(sb)
}