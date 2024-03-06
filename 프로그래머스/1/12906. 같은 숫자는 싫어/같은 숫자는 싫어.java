import java.util.List;
import java.util.ArrayList;

public class Solution {
    public int[] solution(int[] arr) {
        // 1. stack 생성
        List<Integer> stack = new ArrayList<Integer>();

        // 2. 배열 arr 처음부터 끝까지 순서대로 중복되지않게 stack에 푸쉬
        int currentValue = -1;
        for(int start = 0; start < arr.length; start++) {
            if(arr[start] != currentValue) { 
                stack.add(arr[start]);
                currentValue = arr[start];
            }
        }

        // 3. List<Integer> -> int[]
        return stack.stream().mapToInt(e -> e).toArray();
    }
}