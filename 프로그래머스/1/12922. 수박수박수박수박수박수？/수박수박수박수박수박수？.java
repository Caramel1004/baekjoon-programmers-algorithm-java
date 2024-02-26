import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public String solution(int n) {
        //인덱스가 0 ~ n - 1 까지 "수" or "박" 으로 구성된 문자열 반환
        // String[]{String[index]...} -> String
        return IntStream.range(0, n)
            .mapToObj(index -> index % 2 == 0 ? "수" : "박")
            .collect(Collectors.joining());
    }
}