class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int denom = denom1 * denom2;
        int numer = numer1 * denom2 + numer2 * denom1;

        int gcd = getGCD(denom, numer); // 최대 공약수
        while (gcd > 1) {
            denom /= gcd;
            numer /= gcd;

            gcd = getGCD(denom , numer);
        }

        return new int[]{numer, denom};
    }

    
    public static int getGCD (int x, int y) {
        if(y == 0) {
            return x;
        }
        return getGCD(y,x % y);
    }
}