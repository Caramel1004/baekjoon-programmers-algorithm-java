import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Long> solution(int x, int n) {
        // 1. element타입이 long인 ArrayList 선언
        List<Long> answer = new ArrayList<Long>();

        // 2. 반복문으로 x를 1씩 증가하는 index값배 하여 ArrayList에 저장
        for(long index = 1; index <= n; index++) {
            answer.add(x * index);
        }
        
        return answer;
    }
}