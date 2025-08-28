import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        
        long[] nums = new long[size];
        for(int i = 0; i < size; i++){
            nums[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(nums);

        // key: 갯수 종류, value: 해당 갯수만큼 가지고 있는 요소
        Map<Integer, Long> map = new HashMap<>();
        int maxOfKey = 1;
        map.put(maxOfKey, nums[0]);
        for(int i = 0; i < size; i++) {
            int count = 1;
            while(i + 1 < size && nums[i] == nums[i + 1]) {
                count++;
                if(map.getOrDefault(count, nums[i]) >= nums[i]) {
                    map.put(count, nums[i]);
                }
                i++;
            }
            // 최대 갯수 최신화
            if(maxOfKey < count) {
                maxOfKey = count;
            }
        }
        System.out.print(map.get(maxOfKey));
    }
}