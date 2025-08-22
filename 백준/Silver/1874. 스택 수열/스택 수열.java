import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int loopCount = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        int acc = 1;
        for(int i = 0; i < loopCount; i++){
            int target = Integer.parseInt(br.readLine());
            while(acc <= target){
                stack.push(acc);
                sb.append("+").append("\n");
                acc++;
            }
            if(!stack.isEmpty() && stack.peek() == target){
                stack.pop();
                sb.append("-").append("\n");
            }
        }
        System.out.println(stack.isEmpty() ? sb : "NO");
    }
}