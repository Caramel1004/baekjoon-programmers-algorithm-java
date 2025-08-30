import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        
        // 막대기 개수 = x의 이진수에서 1의 개수
        System.out.println(Integer.bitCount(x));
    }
}
