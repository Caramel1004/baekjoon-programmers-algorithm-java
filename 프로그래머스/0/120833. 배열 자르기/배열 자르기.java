import java.util.Arrays;

class Solution {
    /** 내 풀이1 */
    public static int[] solution(int[] numbers, int num1, int num2) {
        // 인덱스 num1 부터 인덱스 num2까지 배열 카피
        return Arrays.copyOfRange(numbers, num1, num2 + 1);
    }

    /** 내 풀이2 */
    public int[] solution2(int[] numbers, int num1, int num2) {
        return IntStream.rangeClosed(num1, num2).map(i -> numbers[i]).toArray();
    }

    /** 내 풀이3 */
    public int[] solution3(int[] numbers, int num1, int num2) {
        return Arrays.stream(numbers, num1, num2+1).toArray();
    }
}
