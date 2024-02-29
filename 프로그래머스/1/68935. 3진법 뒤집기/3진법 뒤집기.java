import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.ArrayList;

class Solution {
    public static int solution(int n) {
        // 1. int -> 3진법 String
        String samJinBub = Integer.toString(n, 3);

        // 2. String -> String[] -> List<String>
        List<String> samJinBubList = new ArrayList<String>(List.of(samJinBub.split("")));
        
        // 3. 반대로 재정렬
        Collections.reverse(samJinBubList);

        // 4. List<String> -> String -> int
        return Integer.parseInt(String.join("", samJinBubList), 3);
    }
}