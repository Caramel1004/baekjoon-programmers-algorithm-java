import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * 수열
     * n    cnt
     * 1    1
     * 2    3
     * 3    5
     * 4    11
     * 5    21
     * 6    43
     * 7    85
     * 8    171
     * 9    341
     * 10   683
     * 11   1365
     * 12   2731
     *
     * f(n) = f(n-1) + 2f(n-2)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = i == 2 ? 3 : (dp[i - 1] + (2 * dp[i - 2])) % 10_007;
        }

        System.out.println(dp[n]);
    }

}
