import java.util.*;

class Solution {
    public static String solution(String str) {
        List<String> strList = new ArrayList<String>(Arrays.asList(str.split("")));

        Collections.reverse(strList);

        return String.join("", strList);
    }
}