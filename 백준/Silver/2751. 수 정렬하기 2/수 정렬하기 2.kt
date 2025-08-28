fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    
    val loopCount = br.readLine().toInt()
    
    val nums = (0..<loopCount)
        .asSequence()
        .map { br.readLine().toInt() }
        .sorted()
    
    nums.forEach { sb.appendLine(it) }
    
    println(sb)
}