import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public StringBuilder solution(String str) {
        // 1. 요소가 Integer타입인 List로 변환
        List<Integer> integerList = Arrays.stream(str.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        // 2. 원시 int형으로 변환 후 최대 최소 찾기
        int max = integerList.stream().mapToInt(num -> num).max().orElse(0);
        int min = integerList.stream().mapToInt(num -> num).min().orElse(0);
        
        return new StringBuilder().append(min).append(" ").append(max);
    }
}