class Solution {
    /** 방법(내 풀이) 1. 반복문으로 처리 */
    public double solution(int[] arr) {
        int arrLength = arr.length;
        int sum = 0;
        
        for(int num : arr) {
            sum += num;
        }
        
        // 평균
        return (double) sum / (double) arrLength;
    }

    /** 방법 2. 스트림으로 변환하여 평균내기 */
    public double solution2(int[] arr) {
      return (double) Arrays.stream(arr).average().orElse(0);
    }
}
