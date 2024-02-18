class Solution {
    public double solution(int[] arr) {
        int arrLength = arr.length;
        int sum = 0;
        
        for(int num : arr) {
            sum += num;
        }
        
        // 평균
        return (double) sum / (double) arrLength;
    }
    
}