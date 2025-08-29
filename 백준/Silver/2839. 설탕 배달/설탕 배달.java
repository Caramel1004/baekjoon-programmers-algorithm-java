import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int weight = Integer.parseInt(br.readLine());
        int largestEnvelopeCount = weight / 5;
        int envelopeCount = -1;
        for(int count = largestEnvelopeCount; count >= 0; count--) {
            if((weight - (5 * count)) % 3 == 0) {
                envelopeCount = count + (weight - (5 * count)) / 3;
                break;
            }
        }
        System.out.println(envelopeCount);
    }
}