import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr) {
        // 1. 최솟값 조회
        int min = IntStream.of(arr).min().orElse(-1);
        
        // 2. 배열에서 최솟값이랑 같은 요소 제거
        int[] newArr = IntStream.of(arr)
            .filter(e -> e != min)
            .toArray();
        
        return newArr.length > 0 ? newArr : new int[]{-1};
    }
}