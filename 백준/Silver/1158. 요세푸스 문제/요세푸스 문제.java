import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        firstSolution(Integer.parseInt(st.nextToken()),  Integer.parseInt(st.nextToken()));
    }

    private static void firstSolution(int n, int k) throws IOException {
        Deque<Integer> que = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        // 방향: <-
        // [1, 2, 3, 4, 5 ... n]
        for(int i = 1; i <= n; i++){
            que.addLast(i);
        }

        while(!que.isEmpty()){
            // k - 1 번 반복해서 k 전까지 회전
            for(int i = 0; i < k - 1; i++) {
                que.addLast(que.removeFirst());
            }
            // k 번째 이므로 앞에서 poll
            sb.append(que.removeFirst()).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }
}