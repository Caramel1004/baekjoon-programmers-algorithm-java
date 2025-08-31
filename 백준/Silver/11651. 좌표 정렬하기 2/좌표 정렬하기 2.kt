import java.util.StringTokenizer

private data class Coordinate(val x: Int, val y: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val coordinates = (0..<br.readLine().toInt())
        .map {
            val st = StringTokenizer(br.readLine())
            Coordinate(
                x = st.nextToken().toInt(),
                y = st.nextToken().toInt()
            )
        }
        .sortedWith(compareBy(Coordinate::y, Coordinate::x))
    for (coordinate in coordinates) {
        sb.append(coordinate.x)
            .append(" ")
            .append(coordinate.y)
            .append("\n")
    }
    print(sb)
}