import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public String solution(String str) {
        // 1. String -> String[] -> List<String>
        List<String> strList = new ArrayList<String>(List.of(str.split("")));

        // 2. sort 내림 차순
        strList.sort(Comparator.reverseOrder());

        // 3. List<String> -> String
        return strList.stream().collect(Collectors.joining());
    }
}