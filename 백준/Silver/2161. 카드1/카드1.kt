fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    val deque = ArrayDeque<Int>()
    for(i in 1..br.readLine().toInt()) {
        deque.addLast(i)
    }

    while(deque.size > 1) {
        sb.append(deque.removeFirst()).append(' ')
        deque.addLast(deque.removeFirst())
    }
    sb.append(deque[0])

    print(sb)
}