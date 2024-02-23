import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        // 1. int[] -> List<Integer>
        List<Integer> factorList = Arrays.stream(arr)
            .filter(e -> e % divisor == 0)
            .boxed()
            .collect(Collectors.toList());
        
        // 2. 오름차순 정렬
        factorList.sort(Comparator.naturalOrder());
        
        // 3. 리스트 길이 0 이면 -1 추가
        if(factorList.size() <= 0) {
            factorList.add(-1);
        }
        
        // 4. List<Integer> -> int[]
        return factorList.stream().mapToInt(x -> x).toArray();
    }
}