class Solution {
    public int solution(int slice, int n) {
        final int PIZZA_MAX_COUNT = (100 / slice) + 1;
        int count = 0;
        
        // slice배수랑 n 비교해서 n보다 크거나 같으면 count에 index 값 저장하고 브레이크
        for(int index = 1; index <= PIZZA_MAX_COUNT; index++) {
            if(n <= slice * index) {
                count = index;
                break;
            }
        }
        
        return count;
    }
}