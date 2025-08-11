class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = firstSolution(array, commands)
        return answer
    }
    
    private fun firstSolution(
        array: IntArray,
        commands: Array<IntArray>
    ): IntArray {
        val answer = mutableListOf<Int>()
        for(command in commands) {
            // 1. (command[0] - 1) ~ command[1] sub => 문제에서는 1번째가 시작점이므로 탐색 시 command[0] - 1로 계산
            val subArray = array.copyOfRange(command[0] - 1, command[1])
            // 2. 오름 차순 정렬
            subArray.sort()
            // 3. K번째 요소 저장
            answer += subArray[command[2] - 1]
        }
        return answer.toIntArray()
    }
}