class Solution {
    fun solution(s: String): IntArray {
        return firstSolution(s)
    }
    
    private fun firstSolution(s: String): IntArray {
        var removedZeroCount = 0
        var trialCount = 0;
        var keyword = s
        while (keyword != "1") {
            // 1. '0' 갯수 카운팅
            removedZeroCount += keyword.count { it == '0' }
            // 2. 문자열에서 "0" 을 빈 문자열로 대체 => 0 제거 => 문자열 길이 => 2진수로 변환
            keyword  = keyword.replace("0", "").length.toString(2)
            // 3. 시도 횟수 1증가
            trialCount++
        }
        return intArrayOf(trialCount, removedZeroCount)
    }
}