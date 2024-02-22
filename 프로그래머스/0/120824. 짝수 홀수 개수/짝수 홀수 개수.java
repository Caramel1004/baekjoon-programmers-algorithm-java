import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    /** 내 풀이 */
    public int[] solution(int[] nums) {
        int evenCount = Arrays.stream(nums)
            .filter(num -> num % 2 == 0)
            .toArray()
            .length;
        
        int oddCount = Arrays.stream(nums)
            .filter(num -> num % 2 != 0)
            .toArray()
            .length;
        
        
        return new int[]{evenCount, oddCount};
    }
    
    /** 다른 유저 풀이 */
    public int[] solution2(int[] numList) {
        return IntStream.of(
            (int) Arrays.stream(numList).filter(i -> i % 2 == 0).count(), 
            (int) Arrays.stream(numList).filter(i -> i % 2 == 1).count())
            .toArray();
    }
}