class Solution {
    public int solution(int n) {
        int sum = 0;

        // 1 ~ n까지 순차적으로 n 나눠서 나머지가 0인것만 더하기
        for(int index = 1; index <= n; index++) {
            if(n % index == 0) {
                sum += index;
            }
        }

        return sum;
    }
}