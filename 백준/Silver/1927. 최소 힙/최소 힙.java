import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < size; i++){
            int num = Integer.parseInt(br.readLine());
            if(num != 0) {
                pq.offer(num);
            } else {
                int min = pq.peek() == null ? 0 : pq.poll();
                sb.append(min).append("\n");
            }
        }
        System.out.println(sb);
    }
}