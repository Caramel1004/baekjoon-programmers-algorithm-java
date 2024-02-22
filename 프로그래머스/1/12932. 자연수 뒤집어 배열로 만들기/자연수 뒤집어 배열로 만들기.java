import java.util.*;

class Solution {
    public static int[] solution(long n) {
        // long -> String -> String[] -> List<String> -> int[]
        List<String> strList = new ArrayList<String>(List.of(Long.toString(n).split("")));

        Collections.reverse(strList);

        return strList.stream()
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}