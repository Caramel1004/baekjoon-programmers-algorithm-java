import java.util.Arrays;

class Solution {
    public int solution(int n) {
        return search(n);
    }
    
    /**
     * 8 => 1000 => 16bit => 비트 4개
     * 9 => 1001
     * 10 => 1010
     * 11 => 1011
     * 12 = 8 + 4 => 1100
     * 13 = 8 + 4 + 1 => 1101
     * 14 = 8 + 4 + 2 => 1110
     * 15 = 8 + 4 + 2 + 1 => 1111
     * 16 => 10000 => 32bit => 비트 5개
     * 78 = 64 + 8 + 4 + 2 => 1001110,  83 = 64 + 16 + 2 + 1 => 1010011
     */
    
    // 시간 초과
    private static int search(int num) {
        int bitOnesCount = Integer.bitCount(num);
        // 1. 2의 거듭 제곱 수는 다음 거듭 제곱 수로 처리
        if (bitOnesCount == 1) {
            return num << 1;
        }
        // 2. num을 2의 거듭 제곱 수들로 분해
        int[] bitPowers = new int[bitOnesCount];
        int operand = num;
        for (int i = 0; i < bitPowers.length; i++) {
            int totalBitCount = Integer.toBinaryString(operand).length(); // 총 비트 수
            int exponent = totalBitCount - 1;
            int highestPowerOfTwo = 1 << exponent;
            bitPowers[i] = highestPowerOfTwo;
            operand %= highestPowerOfTwo;
        }
        /* 3. 맨 오른쪽부터 순차적으로 왼쪽 쉬프트가 가능한 비트 탐색
         * Exam)
         * 1100011 -> 1100101
         * 1000111 -> 1001011
         * 1001011 -> 1001101
         * 1001101 -> 1001110
         * 10010110 -> 10011001
         * 1111000 -> 10000111
         */
        int[] nextBitPowers = bitPowers.clone();
        for (int idx = nextBitPowers.length - 1; idx > 0; idx--) {
            // n번째 비트가 왼쪽으로 쉬프트가 가능한 경우
            if (nextBitPowers[idx - 1] != nextBitPowers[idx] << 1) {
                nextBitPowers[idx] <<= 1;
                int remainedOnesCount = bitOnesCount - (idx + 1);
                int currentBit = 1;
                // 맨 오른쪽 비트부터 순차적으로 1 채우기
                for (int i = nextBitPowers.length - 1; remainedOnesCount > 0; i--) {
                    nextBitPowers[i] = currentBit;
                    currentBit <<= 1;
                    remainedOnesCount--;
                }
                break;
            }
            // 인덱스 1번째 요소도 왼쪽 쉬프트가 불가능한 경우
            if(idx == 1) {
                // 0번째 요소 왼쪽 쉬프트
                nextBitPowers[idx - 1] <<= 1;
                int remainedOnesCount = bitOnesCount - idx;
                int currentBit = 1;
                // 맨 오른쪽부터 순차적으로 1채우기
                for (int i = nextBitPowers.length - 1; remainedOnesCount > 0; i--) {
                    nextBitPowers[i] = currentBit;
                    currentBit <<= 1;
                    remainedOnesCount--;
                }
            }
        }
        int sum = 0;
        for(int pow : nextBitPowers) {
            sum += pow;
        }
        return sum;
    }
}