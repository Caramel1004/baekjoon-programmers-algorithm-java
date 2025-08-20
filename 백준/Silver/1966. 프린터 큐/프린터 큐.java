import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int loopCount = Integer.parseInt(br.readLine());
        // loop scope
        for(int i = 0; i < loopCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int docCount = Integer.parseInt(st.nextToken());
            int targetKey = Integer.parseInt(st.nextToken());

            // ex) deque: [0, 1, 2, 3, 4, 5]
            Deque<Integer> deque = new ArrayDeque<>();
            // ex) map : {0=1, 1=1, 2=9, 3=1, 4=1, 5=1}
            HashMap<Integer, Integer> map = new HashMap<>();
            int order = 0;

            // key: 순서 번호 키, value: 중요도
            st = new StringTokenizer(br.readLine());
            int max = 0;
            for(int k = 0; k < docCount; k++){
                int importance = Integer.parseInt(st.nextToken());
                if(max < importance){
                    max = importance;
                }
                map.put(k, importance);
                deque.addLast(k);
            }

            while(!deque.isEmpty() && map.containsKey(targetKey)){
                int searchKey = deque.peekFirst();
                int peekValue = map.get(searchKey);
                if(peekValue >= max){
                    deque.pollFirst();
                    order++;
                    map.remove(searchKey);
                    if(!map.isEmpty()){ max = Collections.max(map.values()); }
                } else {
                    deque.addLast(deque.pollFirst());
                }
            }
            sb.append(order).append("\n");
        }

        System.out.print(sb);
    }
}