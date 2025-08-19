import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int siteCount = Integer.parseInt(st.nextToken());
        int searchCount = Integer.parseInt(st.nextToken());
        HashMap<String, String> hash = new HashMap<>();

        for(int i = 0; i < siteCount; i++){
            st = new StringTokenizer(br.readLine());
            hash.put(st.nextToken(), st.nextToken());
        }

        for(int i = 0; i < searchCount; i++){
            sb.append(hash.get(br.readLine())).append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}