import java.util.Arrays;

class Solution {
    /**
     * 배열에 짝수만 존재하면 0 리턴
     * 홀짝짝 or 홀홀홀 조합이 나와야 소수가 있을 가능성 존재
     */
    public int solution(int[] nums) {
        int caseNumber = 0;
        int[] evens = Arrays.stream(nums).filter(num -> num % 2 == 0).toArray();
        int[] odds = Arrays.stream(nums).filter(num -> num % 2 == 1).toArray();
        // 배열에 짝수만 존재하면 0 리턴
        if (isEmpty(odds)) {
            return 0;
        }
        // 홀홀홀
        if (odds.length >= 3) {
            // 5
            // 0 1 2 3 4
            // 1 3 5 7 9
            for (int i = 0; i + 2 < odds.length; i++) {
                int firstPointer = i + 1;
                while (firstPointer < odds.length - 1) {
                    int secondPointer = firstPointer + 1;
                    while (secondPointer < odds.length) {
                        int sum = odds[i] + odds[firstPointer] + odds[secondPointer];
                        if (isPrime(sum)) {
                            ++caseNumber;
                        }
                        secondPointer++;
                    }
                    firstPointer++;
                }
            }
        }
        // 홀짝짝
        if (!isEmpty(odds) && evens.length >= 2) {
            for (int odd : odds) {
                for (int i = 0; i + 1 < evens.length; i++) {
                    int pointer = 1;
                    while (i + pointer < evens.length) {
                        int sum = odd + evens[i] + evens[i + pointer];
                        if (isPrime(sum)) {
                            ++caseNumber;
                        }
                        pointer++;
                    }
                }
            }
        }
        return caseNumber;
    }

    private static boolean isPrime(int num) {
        boolean isTrue = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isEmpty(int[] array) {
        return array.length == 0;
    }
}