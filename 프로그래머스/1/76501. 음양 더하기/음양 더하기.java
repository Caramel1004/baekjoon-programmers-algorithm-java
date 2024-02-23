import java.util.stream.IntStream;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int[] integs = new int[absolutes.length];

        for(int i = 0; i < absolutes.length; i++) {
            integs[i] = signs[i]? absolutes[i] : absolutes[i] * -1;
        }

        return IntStream.of(integs)
                .sum();
    }

}