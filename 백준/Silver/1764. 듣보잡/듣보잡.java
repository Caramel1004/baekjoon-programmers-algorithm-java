import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // key-value에서 value를 사용하지 않아서 리팩토링
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(br.readLine());
        }

        int count = 0;
        for(int i = 0; i < m; i++) {
            String word = br.readLine();
            if (set.contains(word)) {
                sb.append(word).append("\n");
                count++;
            }
        }

        String[] words = sb.toString().split("\\n");

        Arrays.sort(words);

        sb.delete(0, sb.length());
        sb.append(count).append("\n");
        Arrays.stream(words).forEach(s -> sb.append(s).append("\n"));
        System.out.print(sb);
    }
}