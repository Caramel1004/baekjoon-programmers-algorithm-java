class Solution {
    public int solution(int n) {
        final int PIZZA_PIECE = 7; // 피자조각
        final int PIZZA_MAX_COUNT = (100 / PIZZA_PIECE) + 1;
        int count = 0;
        
        // 1. 7의 배수로 인원수 비교
        for(int index = 1; index <= PIZZA_MAX_COUNT; index++) {
            if(n <= (PIZZA_PIECE * index)) {
                count = index;
                break;
            }
        }
        
        return count;
    }
}