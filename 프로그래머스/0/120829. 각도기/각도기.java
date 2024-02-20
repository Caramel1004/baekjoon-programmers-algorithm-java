class Solution {
    public int solution(int angle) {
        if(angle > 0 && angle < 90) {  // 예각
            return 1;
        }
        
        if(angle == 90) {              // 직각
            return 2;
        }
        
        if(angle > 90 && angle < 180) {// 둔각
            return 3;
        }
        
        if(angle == 180) {             // 평각
            return 4;
        }
        
        return -1;
    }
}