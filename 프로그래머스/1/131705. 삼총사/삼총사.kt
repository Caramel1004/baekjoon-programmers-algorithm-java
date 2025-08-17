class Solution {
    fun solution(number: IntArray): Int {
        var count = 0;
        val lastIndex = number.size - 1
        for(i in 0..lastIndex) {
            for(j in (i + 1)..lastIndex) {
                for(k in (j + 1)..lastIndex) {
                    if(number[i] + number[j] + number[k] == 0) {
                        count++
                    }
                }
            }
        }
        return count
    }
}