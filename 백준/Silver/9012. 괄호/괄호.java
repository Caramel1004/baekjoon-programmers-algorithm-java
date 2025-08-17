import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int loopCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < loopCount; i++) {
            if(!isValid(br.readLine())) {
                bw.write("NO\n");
            } else {
                bw.write("YES\n");
            }
        }

        br.close();
        bw.close();
    }

    private static boolean isValid(String bracketStr) {
        int count = 0;
        for (int idx = 0; idx < bracketStr.length(); idx++) {
            if (bracketStr.charAt(idx) == '(') {
                count++;
            }
            if (bracketStr.charAt(idx) == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}