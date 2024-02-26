class Solution {
    public String solution(String str) {
        String[] strArr = str.split("");
        int lastIndex = strArr.length - 1;
        
        return lastIndex % 2 == 0 ? strArr[lastIndex / 2] : strArr[lastIndex / 2] + strArr[(lastIndex / 2) + 1];
    }
}