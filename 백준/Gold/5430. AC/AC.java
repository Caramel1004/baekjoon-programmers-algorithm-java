import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int TEST_SIZE = Integer.parseInt(br.readLine());

        for (int i = 0; i < TEST_SIZE; i++) {
            String commandFunc = br.readLine(); // ex) RDD, DD
            final int DEQUE_SIZE = Integer.parseInt(br.readLine());

            String[] elements = br.readLine()
                    .replace("[", "")
                    .replace("]", "")
                    .split(",");
            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 0; j < DEQUE_SIZE; j++) {
                deque.addLast(Integer.parseInt(elements[j]));
            }
            try {
                boolean isReversed = false; // 역순이니?
                for (int j = 0; j < commandFunc.length(); j++) {
                    char command = commandFunc.charAt(j);
                    if (command == 'R') {
                        isReversed = !isReversed;
                    } else if (command == 'D') {
                        if(isReversed) { // 역순이면 뒤에서 poll
                            deque.removeLast();
                        } else { // 역순이 아니면 앞에서 poll
                            deque.removeFirst();
                        }
                    } else {
                        throw new NoSuchElementException("Invalid command");
                    }
                }
                sb.append("[");
                while (!deque.isEmpty()) {
                    if(isReversed) {
                        sb.append(deque.removeLast());
                    } else {
                        sb.append(deque.removeFirst());
                    }
                    if(!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]").append("\n");
            } catch (NoSuchElementException e) {
                sb.append("error").append("\n");
            }
        }
        System.out.print(sb.toString().trim());
    }
}