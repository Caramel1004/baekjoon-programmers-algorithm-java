import kotlin.math.sqrt

class Solution {
    fun solution(n: Int): Int = if (sqrt(n.toDouble()) % 1 == 0.0) 1 else 2
}
