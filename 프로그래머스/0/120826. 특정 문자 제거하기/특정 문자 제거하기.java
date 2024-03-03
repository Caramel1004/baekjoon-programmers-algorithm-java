import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String myString, String letter) {
        return Arrays.stream(myString.split(""))
            .filter(e -> !e.equals(letter))
            .collect(Collectors.joining());
    }
}