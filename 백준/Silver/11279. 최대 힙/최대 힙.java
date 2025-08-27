import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());

        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < size; i++){
            int num = Integer.parseInt(br.readLine());
            if(num != 0) {
                pq.offer(num);
            } else {
                int max = pq.peek() == null ? 0 : pq.poll();
                sb.append(max).append("\n");
            }
        }
        System.out.println(sb);
    }
}
