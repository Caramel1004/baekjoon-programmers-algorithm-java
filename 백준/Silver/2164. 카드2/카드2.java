import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loopCount = Integer.parseInt(br.readLine());
        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= loopCount; i++) {
            que.push(i);
        }

        // removeLast -> peekLast -> push -> removeLast
        while(que.size() > 1){
            que.removeLast();
            que.push(que.peekLast());
            que.removeLast();
        }

        System.out.println(que.peek());
        br.close();
    }
}