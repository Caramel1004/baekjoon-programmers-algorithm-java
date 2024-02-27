import java.util.stream.LongStream;

class Solution {
    public long solution(int price, int money, int count) {
        // 1. 1 ~ count 차례대로 price와 곱해서 모든 요소 합
        long pay = LongStream.rangeClosed(1, count)
            .map(cnt -> {
                return (long) (price * cnt);
            })
            .sum();
        
        // 보유 금액에서 지불할돈 빼서 음수가 나오면 음수인 부족한 금액 절댓값으로 변환 리턴
        return money - pay >= 0 ? 0 : Math.abs(money - pay);
    }
}