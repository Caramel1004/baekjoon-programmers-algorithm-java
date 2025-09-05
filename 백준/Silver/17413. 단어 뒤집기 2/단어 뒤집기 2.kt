fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val tokens = Regex("<[^>]+>|[^<>\\s]+").findAll(br.readLine()).map { it.value }.toList()

    val regex = Regex("^<[^>]+>$")
    tokens.forEach {
        if(!regex.matches(it)) {
            sb.append(it.reversed()).append(" ")
        } else {
            sb.append(it)
        }
    }
    println(sb.toString().replace(" <", "<"))
}