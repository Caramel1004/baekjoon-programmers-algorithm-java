import java.util.List;
import java.util.ArrayList;

class Solution {

    /** 방법(내 풀이) 1. ArrayList에 요소 추가해서 반복문으로 처리 */
    public List<Long> solution(int x, int n) {
        // 1. element타입이 long인 ArrayList 선언
        List<Long> answer = new ArrayList<Long>();

        // 2. 반복문으로 x를 1씩 증가하는 index값배 하여 ArrayList에 저장
        for(long index = 1; index <= n; index++) {
            answer.add(x * index);
        }
        
        return answer;
    }

    /** 방법 2. stream으로 처리 */
    public long[] solution2(int x, int n) {
        return LongStream.iterate(x, i->i+x).limit(n).toArray();
    }
    
    public long[] solution2_1(int x, int n) {
        return LongStream.rangeClosed(1, n).map(v -> v *= x).toArray();
    }
}
