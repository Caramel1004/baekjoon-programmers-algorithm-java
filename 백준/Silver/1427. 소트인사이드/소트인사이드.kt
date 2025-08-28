fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    
    val nums = br.readLine().split("")
        .asSequence()
        .filter(String::isNotEmpty)
        .map { it.toInt() }
        .sortedDescending()

    nums.forEach { sb.append(it) }
    print(sb)
}