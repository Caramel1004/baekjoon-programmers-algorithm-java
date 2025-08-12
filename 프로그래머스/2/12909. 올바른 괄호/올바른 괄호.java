class Solution {
    // 스택/큐 유형인지 모르는 상태
    boolean solution(String s) {
        return secondSolution(s);
    }
    // 스택/큐 유형인지 모르는 상태
    // 인덱스의 위치로 접근하여 인덱스 범위로 해결하려 했지만 "(()())" 엣지케이스 발견
    // failure
    private static boolean firstSolution(String s) {
        String[] brackets = s.split("");
        // 탐색 후 다음 시행에서 시작 인덱스 위치
        int pointer = 0;
        while (pointer < brackets.length) {
            // 열린 괄호 카운팅
            int openBracketCount = 0;
            for(int i = pointer; i < brackets.length; i++) {
                if(brackets[i].equals(")")) {
                    // 닫힌 괄호 발견 시, 반복문 중지
                    break;
                }
                // 열린 괄호 카운트
                pointer = i;
                openBracketCount++;
            }
            if(openBracketCount <= 0) {
                // 첫 시행부터 닫힌 구간 이면 false 리턴
                return false;
            }
            // 닫힌 괄호가 몇 번째 인덱스까지 있는지 탐색
            int closeBracketCount = 0;
            for(int i = pointer + 1; i < brackets.length; i++) {
                if(brackets[i].equals("(")) {
                    // 열린 괄호 발견 시, 반복문 중지
                    break;
                }
                // 닫힌 괄호 카운트
                pointer = i;
                closeBracketCount++;
            }
            if(openBracketCount != closeBracketCount) {
                return false;
            }
            // 반복문이 끝날 때, pointer로 다음 시행 인덱스 위치 선정
            pointer++;
        }
        return true;
    }

    // 스택/큐 유형인지 모르는 상태
    // 배열을 탐색과 동시에 열린 괄호와 닫힌 괄호 갯수 카운트
    // success
    private static boolean secondSolution(String s) {
        String[] brackets = s.split("");
        int count = 0;
        for (String bracket : brackets) {
            if (bracket.equals("(")) {
                count++;
            }
            if (bracket.equals(")")) {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}