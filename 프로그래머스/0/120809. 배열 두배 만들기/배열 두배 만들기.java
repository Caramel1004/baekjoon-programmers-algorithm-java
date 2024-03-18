class Solution {
    public int[] solution(int[] numbers) {
        
        int[] newArr = new int[numbers.length];
        int index = 0;
        
        for(int num : numbers) {
            newArr[index] = numbers[index] * 2;
            index++;
        }
        
        return newArr;
    }
}