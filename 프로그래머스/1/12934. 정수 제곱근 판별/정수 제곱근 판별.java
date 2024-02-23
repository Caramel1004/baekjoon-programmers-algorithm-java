class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt((double)n);
        
        // long으로 형변환시 소수부분은 버리므로 소수부분을 버려도 두 수가 같다면 sqrt는 정수형
        return sqrt == (long)sqrt? (long) Math.pow(sqrt + 1, 2) : -1;
    }
}