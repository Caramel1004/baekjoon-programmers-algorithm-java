import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.ArrayDeque;

class Solution {
    public int solution(String s) {
        return forthSolution(s);
    }
    
    
    // 정확성: 통과, 효율성: 시간 초과
    private static int firstSolution(String s) {
        String str = s;
        for(int idx = 1; idx < str.length(); idx++) {
            if(str.charAt(idx - 1) == str.charAt(idx)) {
                str = str.substring(0, idx - 1) + str.substring(idx + 1);
                idx = 0;
            }
        }
        return str.isEmpty() ? 1 : 0;
    }
    
    // 정확성: 통과, 효율성: 시간 초과
    private static int secondSolution(String s) {
        List<String> strs = Arrays
            .stream(s.split(""))
            .collect(Collectors.toList());
         for(int idx = 1; idx < strs.size(); idx++) {
            if(strs.get(idx - 1).equals(strs.get(idx))) {
                strs.remove(idx - 1);
                strs.remove(idx - 1);
                idx = 0;
            }
        }
        return strs.isEmpty() ? 1 : 0;
    }
    
    // 정확성: 통과, 효율성: 시간 통과
    private static int forthSolution(String s) {
        int len = s.length();
        if(len % 2 != 0) {
            return 0;
        }
        // 문자열 순회하면서 큐에 맨 마지막 요소와 비교
        ArrayDeque<Character> stack = new ArrayDeque<>();
        stack.push(s.charAt(0));
        for(int idx = 1; idx < len; idx++) {
            if(!stack.isEmpty() && stack.peek() == s.charAt(idx)) {
                stack.pop();
            } else {
                stack.push(s.charAt(idx));
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}