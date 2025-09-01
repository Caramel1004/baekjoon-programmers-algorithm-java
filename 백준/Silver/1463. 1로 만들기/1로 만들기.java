import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(1, 0);
        dp.put(2, 1);
        dp.put(3, 1);
        for (int i = 4; i <= num; i++) {
            if(i % 6 == 0) {
                dp.put(i, Math.min(dp.get(i / 3), dp.get(i / 2)) + 1);
            } else if (i % 3 == 0) {
                dp.put(i, Math.min(dp.get(i / 3), dp.get(i - 1)) + 1);
            } else if(i % 2 == 0) {
                dp.put(i, Math.min(dp.get(i / 2), dp.get(i - 1)) + 1);
            } else {
                dp.put(i, dp.get(i - 1) + 1);
            }
        }
        System.out.println(dp.get(num));
    }
}