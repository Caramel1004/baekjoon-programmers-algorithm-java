import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int TEST_SIZE = Integer.parseInt(br.readLine());

        for (int i = 0; i < TEST_SIZE; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int operationCount = Integer.parseInt(br.readLine());
            for (int j = 0; j < operationCount; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                switch (command) {
                    case "I" -> map.put(value, map.getOrDefault(value, 0) + 1);
                    case "D" -> {
                        if (!map.isEmpty()) {
                            int key = value == 1 ? map.lastKey() : map.firstKey();
                            int cnt = map.get(key);
                            if(cnt == 1) {
                                map.remove(key);
                            } else {
                                map.put(key, cnt - 1);
                            }
                        }
                    }
                }
            }
            if (!map.isEmpty()) {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            } else {
                sb.append("EMPTY").append("\n");
            }
        }
        System.out.print(sb.toString().trim());
    }
}