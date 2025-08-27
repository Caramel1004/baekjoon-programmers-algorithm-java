import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int elemCount = Integer.parseInt(st.nextToken());
        int searchKeyCount = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < elemCount; i++) {
            set.add(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < searchKeyCount; i++) {
            if(set.contains(br.readLine())) {
                count++;
            }
        }

        System.out.println(count);
    }
}