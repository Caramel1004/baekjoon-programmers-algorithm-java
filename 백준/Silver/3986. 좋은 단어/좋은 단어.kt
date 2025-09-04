fun main() {
    val br = System.`in`.bufferedReader()
    var count = 0

    repeat(br.readLine().toInt()) {
        val stack = ArrayDeque<Char>()
        val str = br.readLine()
        for(i in 0..str.lastIndex) {
            val peek = stack.firstOrNull()
            if(peek == null || peek != str[i]) {
                stack.addFirst(str[i])
            } else {
                stack.removeFirst()
            }
        }
        count += if(stack.isEmpty()) { 1 } else { 0 }
    }
    print(count)
}