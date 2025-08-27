fun main() {
    val br = System.`in`.bufferedReader()
    br.readLine() // N
    val set = br.readLine().split(" ")
        .map(String::toInt)
        .sorted()
        .toHashSet()
    br.readLine() // M
    val result = br.readLine()
        .split(" ")
        .joinToString(" ") { if(it.toInt() in set) "1" else "0" }
    
    print(result)
}