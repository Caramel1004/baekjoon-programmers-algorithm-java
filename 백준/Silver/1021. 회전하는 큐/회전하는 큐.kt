import java.util.StringTokenizer

private fun <T> ArrayDeque<T>.rotateLeft() = this.addLast(this.removeFirst())
private fun <T> ArrayDeque<T>.rotateRight() = this.addFirst(this.removeLast())

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())

    val dequeSize = st.nextToken().toInt()
    val searchCount = st.nextToken().toInt()

    val deque = ArrayDeque<Int>()
    for (i in 1..dequeSize) {
        deque.addLast(i)
    }

    st = StringTokenizer(br.readLine())
    val queue = ArrayDeque<Int>()
    repeat(searchCount) {
        queue.addLast(st.nextToken().toInt())
    }

    var calCount = 0
    while (queue.isNotEmpty()) {
        val targetIndex = deque.indexOf(queue[0])
        val direction = if (deque.size > 2 * targetIndex) -1 else 1
        val loopCount = if (direction == -1) targetIndex else deque.lastIndex - targetIndex + 1
        repeat(loopCount) {
            if(direction == -1) { // - 방향
                deque.rotateLeft()
            } else { // + 방향
                deque.rotateRight()
            }
            calCount++
        }
        deque.removeFirst()
        queue.removeFirst()
    }
    print(calCount)
}