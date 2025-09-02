import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = 4; // 모든 자연수는 최대 4개의 제곱 수의 합으로 나타낼 수 있으므로 4로 일단 초기화
            int squareRootMaxValue = (int) Math.floor(Math.sqrt(i));
            for(int root = squareRootMaxValue; root > 0; root--){
                dp[i] = Math.min(dp[i], dp[i - root * root] + 1);
                if(dp[i] == 1) { // 완전 제곱 수 인 경우 loop break
                    break;
                }
            }
        }
        System.out.println(dp[n]);
    }
}