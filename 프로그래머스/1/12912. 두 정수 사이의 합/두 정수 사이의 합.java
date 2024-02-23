import java.util.stream.LongStream;

class Solution {
    public long solution(int a, int b) {
        return a >= b? LongStream.rangeClosed(b, a).sum() : LongStream.rangeClosed(a, b).sum();
    }
}