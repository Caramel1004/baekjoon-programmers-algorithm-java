import java.util.*;

public class Solution {
    public int solution(int n) {
        // int -> String -> String[] -> int
        return Arrays.stream(Integer.toString(n).split(""))
            .mapToInt(Integer::parseInt)
            .sum();
    }
}