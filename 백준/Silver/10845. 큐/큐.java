import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int commandCount = Integer.parseInt(st.nextToken());
        Deque<String> deque = new ArrayDeque<>();
        /*
         *   큐 방향
         *   -----------
         *   <- <- <- <-
         *   -----------
         */
        for (int i = 0; i < commandCount; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            String value = st.hasMoreTokens() ? st.nextToken() : null;
            String elem = "";
            switch (command) {
                case "push":
                    deque.offer(value);
                    break;
                case "pop":
                    elem = deque.pollFirst();
                    sb.append(elem == null ? -1 : elem).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    elem = deque.peekFirst();
                    sb.append(elem == null ? -1 : elem).append("\n");
                    break;
                case "back":
                    elem = deque.peekLast();
                    sb.append(elem == null ? -1 : elem).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}