import java.util.stream.IntStream;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        return IntStream.range(0, arr1.length)
                .mapToObj(row -> {
                    int[] colArr = new int[arr1[row].length];

                    for (int col = 0; col < arr1[row].length; col++) {
                        colArr[col] = arr1[row][col] + arr2[row][col];
                    }
                    return colArr;
                })
                .toArray(int[][]::new);
    }
}