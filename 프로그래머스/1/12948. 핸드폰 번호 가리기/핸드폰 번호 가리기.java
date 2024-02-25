import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public String solution(String phoneNumber) {
        String[] phoneNumArr = phoneNumber.split(""); // 문자열 배열
        
        return IntStream.range(0, phoneNumArr.length)
                .mapToObj(index -> {
                    if (index < phoneNumArr.length - 4) {
                        phoneNumArr[index] = "*";
                    }
                    return phoneNumArr[index];
                })
                .collect(Collectors.joining());
    }
}