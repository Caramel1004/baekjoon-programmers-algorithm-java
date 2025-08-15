import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        // return firstSolution(s);
        return secondSolution(s);
    }
    
    // 메모리: 108 MB, 시간: 51.12 ms
    private static int[] firstSolution(String str) {
        int removedZerosCount = 0;
        int trialCount = 0;
        String keyword = str;
        while (!keyword.equals("1")) {
            int onesCount = 0;
            String[] keywords = keyword.split("");
            for (String s : keywords) {
                if (s.equals("0")) {
                    removedZerosCount++;
                }
                if (s.equals("1")) {
                    onesCount++;
                }
            }
            keyword = Integer.toBinaryString(onesCount);
            trialCount++;
        }
        return new int[]{trialCount, removedZerosCount};
    }

    private static int[] secondSolution(String str) {
        int removedZerosCount = 0;
        int trialCount = 0;
        String keyword = str;
        while (!keyword.equals("1")) {
            String[] keywords = keyword.split("");
            int onesCount = (int) Arrays.stream(keywords)
                    .filter(s -> s.equals("1"))
                    .count();
            removedZerosCount += keywords.length - onesCount;
            keyword = Integer.toBinaryString(onesCount);
            trialCount++;
        }
        return new int[]{trialCount, removedZerosCount};
    }
}