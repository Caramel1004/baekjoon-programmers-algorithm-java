import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Schedule {
        int startTime;
        int endTime;

        Schedule(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        
        // 회의 스케쥴 배열
        Schedule[] schedules = new Schedule[size];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            schedules[i] = new Schedule(startTime, endTime);
        }

        // endTime ASC => startTime ASC 
        Arrays.sort(
                schedules,
                Comparator.comparingInt((Schedule s) -> s.endTime)
                        .thenComparingInt((Schedule s) -> s.startTime)
        );
        
        int count = 0;
        int endTime = 0;
        for (Schedule schedule : schedules) {
            if (schedule.startTime >= endTime) {
                endTime = schedule.endTime;
                count++;
            }
        }

        System.out.print(count);
    }
}