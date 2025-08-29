import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new HashSet<>();
        int commandCount = Integer.parseInt(br.readLine());
        for(int i = 0; i < commandCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int value = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : -1;
            switch (command) {
                case "add" -> set.add(value);
                case "remove" -> set.remove(value);
                case "check" -> sb.append(set.contains(value) ? 1 : 0).append("\n");
                case "toggle" -> {
                    if(set.contains(value)) {
                        set.remove(value);
                    } else  {
                        set.add(value);
                    }
                }
                case "all" -> {
                    for(int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                }
                case "empty" -> set.clear();
            }
        }
        System.out.println(sb);
    }
}