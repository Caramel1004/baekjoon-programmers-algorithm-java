import java.util.stream.Collectors;

class Solution {
    public boolean solution(String str) {
        // 1. 문자열 길이가 4 또는 6 이어야함
        if(str.length() != 4 && str.length() != 6) {
            return false;
        }
        
        // 2. String -> char[] -> List<Integer> -> boolean
        return new String(str.toCharArray())
                .chars()
                .mapToObj(e -> (int) e)
                .collect(Collectors.toList())
                .stream()
                .allMatch(e -> e >= 48 && e <= 57);
                // or
                //.allMatch(Character::isDigit);
    }
}