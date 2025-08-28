package baekjoon

import java.util.StringTokenizer

private data class Member(
    val id: Int,
    val name: String,
    val age: Int
)

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    val loopCount = br.readLine().toInt()

    val members = (0..<loopCount)
        .map {
            val st = StringTokenizer(br.readLine())
            val age = st.nextToken().toInt()
            val name = st.nextToken()
            Member(
                id = it,
                name = name,
                age = age
            )
        }
        .sortedWith(compareBy(Member::age, Member::id))

    members.forEach {
        sb.append(it.age)
            .append(" ")
            .append(it.name)
            .append("\n")
    }
    print(sb)
}