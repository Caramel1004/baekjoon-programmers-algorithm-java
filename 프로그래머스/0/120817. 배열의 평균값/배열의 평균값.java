import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public double solution(int[] numbers) {
        return Arrays.stream(numbers).average().getAsDouble();
    }
}