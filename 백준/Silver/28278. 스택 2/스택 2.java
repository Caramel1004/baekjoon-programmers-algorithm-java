import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();

        /*
         *   스택 방향
         *   -----------|
         *   -> -> -> ->|
         *   -----------|
         */
        int commandCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < commandCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int value = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : -1;
            try {
                switch (command) {
                    case 1 -> stack.push(value);
                    case 2 -> sb.append(stack.pop()).append("\n");
                    case 3 -> sb.append(stack.size()).append("\n");
                    case 4 -> sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    case 5 -> {
                        Integer num = stack.peek(); // nullable
                        sb.append(num == null ? -1 : num).append("\n");
                    }
                }
            } catch (RuntimeException e) {
                sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }
}