import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] numbers) {
        return IntStream.of(numbers)
                .map(number -> number * 2)
                .toArray();
    }
}