class Solution {
    /** 내 풀이 */
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
        for(int index = 3; index < n; index++) {
            if(n % index == 1) {
                quotient = index;
                break;
            }
        }
        return quotient;
    }

    /** 다른 사람 풀이 */
    public int solution2(int n) {
        if(n % 2 != 0)
            return 2;
        else {
            for(int i = 3; i <= Math.sqrt(n - 1); i += 2) { // 이 부분은 수학적으로 생각 해 볼 필요가 있을거 같다.
                if((n - 1) % i == 0) 
                    return i;
            }
        }

        return n - 1;
    }
}
