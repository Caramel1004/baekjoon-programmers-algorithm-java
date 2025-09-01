import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        
        Queue<Integer> pq = new PriorityQueue<>(
                Comparator.comparingInt((Integer num) -> Math.abs(num)) // 절댓 값 ASC
                        .thenComparingInt((Integer num) -> num) // 동일한 절댓 값 중 원래 값의 최솟값 ASC
        );
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num != 0) {
                pq.offer(num);
            } else {
                Integer polledElem = pq.poll();
                sb.append(polledElem == null ? 0 : polledElem).append("\n");
            }
        }
        System.out.print(sb);
    }
}