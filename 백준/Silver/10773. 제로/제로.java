import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < size; i++) {
            int elem = Integer.parseInt(br.readLine());
            if(!stack.isEmpty() && elem == 0) {
                stack.pop();
            } else {
                stack.push(elem);
            }
        }

        br.close();
        System.out.print(stack.stream().mapToInt(x -> x).sum());
    }
}