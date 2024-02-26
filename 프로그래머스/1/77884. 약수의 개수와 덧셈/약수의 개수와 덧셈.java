import java.util.stream.IntStream;

class Solution {
    public int solution(int left, int right) {
        
        return IntStream.rangeClosed(left, right)
            .map(num -> {
                int count = 0;
                
                for(int i = 1; i <= num; i++) {
                    count += num % i == 0 ? 1 : 0;
                }
                
                return count % 2 == 0 ? num : num * -1;
            })
            .sum();
    }
}