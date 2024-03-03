class Solution {
    public int[] solution(int money) {
        int americanoPrice = 5500;        
        return new int[]{money / americanoPrice, money % americanoPrice};
    }
}