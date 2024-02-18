class Solution {
    public int solution(int n) {
        int answer = 0;

        if(n % 2 != 0) { // 홀수
            answer = 2;
        }

        if(n % 2 == 0) { // 짝수
            answer = getRemainingNumberOfOne(n);
        }

        return answer;
    }

    public int getRemainingNumberOfOne(int n) {
        int quotient = 0;
        for(int index = 1; index < n; index++) {
            if(n % index == 1) {
                quotient = index;
                break;
            }
        }
        return quotient;
    }
}