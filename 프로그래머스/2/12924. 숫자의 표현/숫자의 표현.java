class Solution {
    /**
     *  k
     *  k + (k + 1)
     *  k + (k + 1) + (k + 2)
     *  k + (k + 1) + (k + 2) + (k + 3)
     *  ......
     *  (index + 1)k + { index (index + 1) / 2 } = n
     *  (index + 1)이 n - { index (index + 1) / 2 }의 약수면 만족 
     */
    public int solution(int n) {
        int count = 0;
        for (int idx = 0; n - (idx * (idx + 1) / 2) > 0; idx++) {
            if((n - (idx * (idx + 1) / 2)) % (idx + 1) == 0) {
                count++;
            }
        }
        return count;
    } 
}