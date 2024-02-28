class Solution {
    public int[] solution(int n, int m) {
        int gcd = getGCD(n, m); // 최대 공약수
        int lcm = gcd * (n / gcd) * (m / gcd); // 최소 공배수
        
        return new int[]{gcd, lcm};
    }
    
    public static int getGCD(int n, int m) {
        if(m == 0) {
            return n;
        }
        
        return getGCD(m, n % m);
    }
}