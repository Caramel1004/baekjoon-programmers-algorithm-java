import java.util.stream.IntStream;

class Solution {
    public int solution(int[] numbers) {
        // 0 ~ 9 합 - numbers 모든 요소의 합
        return IntStream.rangeClosed(0, 9).sum() - IntStream.of(numbers).sum();
    }
}