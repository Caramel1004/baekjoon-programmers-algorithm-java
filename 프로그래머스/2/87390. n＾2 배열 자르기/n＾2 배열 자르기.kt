class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        return secondSolution(n, left, right)
    }
    
    // 메모리 초과, 시간 초과
    private fun firstSolution(n: Int, left: Long, right: Long): IntArray {
        val matrix = Array(n) { IntArray(n) }
        // 1. 행렬에 요소 값 채우기
        for(i in 0 until n) {
            for(j in 0..i) {
                matrix[i][j] = i + 1
                if(i == j) {
                    for(k in i - 1 downTo 0) {
                        matrix[k][j] = i + 1
                    }
                }
            }
        }
        // 2. 1차원 배열로 변환 -> 지정 범위 배열 복사
        return matrix
            .reduce { acc, arr -> acc + arr }
            .copyOfRange(left.toInt(), right.toInt() + 1)
    }
    
    /**
     *  case1
     *  0 1 2   3 4 5   6 7 8
     *  1,2,3 / 2,2,3 / 3,3,3
     *
     *  n = 3 (3개의 구간으로 분리 가능)
     *  left = 2
     *  right = 5
     *
     *  0구간 1구간 2구간
     *  0구간의 2번째 (2 / 3 = 0, 2 % 3 = 2)
     *  1구간의 2번째 (5 / 3 = 1, 5 % 3 = 2)
     *  2구간의 0번째 (6 / 3 = 2, 6 % 3 = 0)
     *
     *  case2
     *  n = 4 (4개의 구간으로 분리 가능)
     *  left = 7
     *  right = 14
     *
     *  1,2,3,4 / 2,2,3,4 / 3,3,3,4 / 4,4,4,4
     *
     *  0구간 1구간 2구간 3구간
     *  1구간의 1번째 (7 / 4 = 1, 7 % 3 = 1)
     *  1구간의 2번째 (14 / 4 = 3, 14 % 4 = 2)
     *
     */
    // 메모리 통과, 시간 통과
    fun secondSolution(n: Int, left: Long, right: Long): IntArray {
        val size = (right - left + 1).toInt()
        val arr = IntArray(size)
        for(i in left..right) {
            val section = (i / n).toInt()
            val idx = (i % n).toInt()
            arr[(i - left).toInt()] = maxOf(section, idx) + 1
        }
        return arr
    }
}