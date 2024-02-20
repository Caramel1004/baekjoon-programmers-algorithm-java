import java.util.stream.IntStream;

class Solution {
    /** 내 풀이 */
    public int solution(int n) {
        int sum = 0;
        
        for(int i = 1; i <= n; i++) {
            if(i % 2 == 0) { // 짝수 필터
                sum += i;
            }
        }
        return sum;
    }
    
    /** 다른 풀이 stream으로 처리 */
    public int solution2(int n) {
        return IntStream.rangeClosed(0, n)
            .filter(e -> e % 2 == 0)
            .sum();
    }
}
