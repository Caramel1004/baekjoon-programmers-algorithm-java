class Solution {
    public int[] solution(int[] nums) {
        int[] reverseArray = new int[nums.length];
        
        for(int i = nums.length - 1; i >= 0; i--) {
            reverseArray[nums.length - 1 - i] = nums[i];
        }
        
        return reverseArray;
    }
}