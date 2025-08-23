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

        // 제공된 단어는 unique
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(br.readLine(), i);
        }

        int count = 0;
        for(int i = 0; i < m; i++) {
            String word = br.readLine();
            if (map.containsKey(word)) {
                sb.append(word).append("\n");
                count++;
            }
        }

        String[] words = sb.toString().split("\n");

        Arrays.sort(words);

        System.out.println(count);
        Arrays.stream(words).forEach(System.out::println);
    }
}