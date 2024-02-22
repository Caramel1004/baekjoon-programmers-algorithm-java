import java.util.Arrays;

class Solution {
    public static int[] solution(int[] numbers, int num1, int num2) {
        // 인덱스 num1 부터 인덱스 num2까지 배열 카피
        return Arrays.copyOfRange(numbers, num1, num2 + 1);
    }
}