import java.util.ArrayList;
class Solution {
    public int solution(String t, String p) {
        int tLength = t.length();// t 문자열 길이
        int pLength = p.length();// p 문자열 길이
        
        // 1. 잘린 문자열을 정수형으로 변환 후 저장할 list 배열
        ArrayList<Long> numbers = new ArrayList<Long>();
        
        // 2. 서칭할 인덱스 범위 range변수에 저장
        int range;
        if(pLength > 1) {
            range = tLength - pLength;
        } else {
            range = tLength - 1;        
        }
        
        // 3. 순차적으로 split 후 정수형으로 리스트 안에 추가
        for(int index = 0; index <= range; index++){
            String splitedStr = t.substring(index, index + pLength);
            
            // 잘린 문자열이 p 문자열길이 보다 작으면 반복문 브레이크
            if(splitedStr.length() < pLength) {
                break;
            }
            long num = Long.parseLong(splitedStr);
            numbers.add(num);
        }
        
        // 2. p보다 작거나 같은 수 필터링 하기
        int count = 0;
        long pNum = Long.parseLong(p);
        for(long num : numbers) {
            if(pNum >= num) {
                count++;
            }
        }
        
        return count;
    }
}