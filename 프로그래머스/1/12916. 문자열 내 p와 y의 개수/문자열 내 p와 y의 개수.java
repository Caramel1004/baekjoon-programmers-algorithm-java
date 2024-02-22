import java.util.Arrays;

class Solution {
    public boolean solution(String str) {
        return Arrays.stream(str.split("")).filter(s -> s.equalsIgnoreCase("p")).count()
                == Arrays.stream(str.split("")).filter(s -> s.equalsIgnoreCase("y")).count();
    }
}