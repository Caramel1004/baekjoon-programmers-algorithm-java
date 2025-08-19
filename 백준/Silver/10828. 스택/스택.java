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
        Deque<String> stack = new ArrayDeque<>();
        /*
        *   스택 방향
        *   -----------|
        *   -> -> -> ->|
        *   -----------|
        */
        for (int i = 0; i < commandCount; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            String value = st.hasMoreTokens() ? st.nextToken() : null;
            String elem = "";
            switch (command) {
                case "push": 
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        elem = stack.pop();
                    } catch (NoSuchElementException e) {
                        elem = "-1";
                    }
                    sb.append(elem == null ? -1 : elem).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "top":
                    elem = stack.peek();
                    sb.append(elem == null ? -1 : elem).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}