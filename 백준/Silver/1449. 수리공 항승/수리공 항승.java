import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int tapeLength = Integer.parseInt(st.nextToken());

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int count = 0;
        for (int i = 0; i < size; i++) {
            int startVal = nums[i];
            int loopCount = 0;
            while (i < size && nums[i] - startVal + 1 <= tapeLength) {
                i++;
                loopCount++;
            }
            if (loopCount > 0) {
                i--;
            }
            count++;
        }
        System.out.println(count);
    }
}