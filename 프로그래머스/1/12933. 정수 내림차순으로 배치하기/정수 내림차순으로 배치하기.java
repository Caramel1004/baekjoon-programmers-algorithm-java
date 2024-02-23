import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * Comparator 객체로 정렬 하기
     * 내림 차순 정렬 Comparator.reverseOrder()
     * 오름 차순 정렬 Comparator.naturalOrder()
    * */
    public long solution(long n) {
        // 1. int -> String -> String[] -> List<Long>
        List<Long> longList = Arrays.stream(Long.toString(n).split(""))
                .mapToLong(Long::parseLong)
                .boxed()
                .collect(Collectors.toList());

        // 2. List 내림 차순 정렬
        longList.sort(Comparator.reverseOrder());
        
        // 3. List<Long> -> String[]
        String[] strArray = longList.stream()
                .map(String::valueOf)
                .toArray(String[]::new);
        
        // String[] -> String -> long
        return Long.parseLong(String.join("", strArray));
    }
}