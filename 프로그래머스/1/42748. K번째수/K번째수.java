import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.time.Duration;
import java.time.Instant;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // firstSolution function test
        // 병합 정렬(시간 복잡도: O(n log n))
        // 걸린 시간: 3.419 ms
        Instant start = Instant.now();
        int[] firstAnswer = firstSolution(array, commands);
        Instant end = Instant.now();
        System.out.println("Duration: " + Duration.between(start, end).toNanos() / 1_000_000.0);

        // secondSolution function test
        // 버블 정렬(시간 복잡도: O(n²))
        // 걸린 시간: 0.011 ms => 배열 길이가 커지면 걸린 시간이 더 늘어날 것으로 예상됨
        start = Instant.now();
        int[] secondAnswer = secondSolution(array, commands);
        end = Instant.now();
        System.out.println("Duration: " + Duration.between(start, end).toNanos() / 1_000_000.0);
        
        // thirdSolution function test
        // 퀵 정렬(시간 복잡도: O(n log n))
        // 걸린 시간: 0.407 ms
        start = Instant.now();
        int[] thirdAnswer = thirdSolution(array, commands);
        end = Instant.now();
        System.out.println("Duration: " + Duration.between(start, end).toNanos() / 1_000_000.0);
        
        return thirdAnswer;
    }
    
    private static int[] firstSolution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        for(int[] command : commands) {
            // 1. Array -> stream -> List
            List<Integer> commandList = Arrays
                    .stream(array)
                    .boxed()
                    .collect(Collectors.toList());
            // 2. command[0] ~ command[1] sub => 문제에서는 1번째가 시작점이므로 리스트로 탐색할 떄, (n - 1) 번째로 시작 계산
            List<Integer> subList = commandList
                    .subList(command[0] - 1, command[1])
                    .stream()
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.toList());
            answer[index++] = subList.get(command[2] - 1);
        }
        return answer;
    }

    private static int[] secondSolution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int idx = 0; idx < commands.length; idx++) {
            // 1. idx번째 추출
            int[] command = commands[idx];

            // 2. 인덱스 범위 변수 저장 (command[0] - 1) ~ (command[1] - 1)
            int fromIndex = command[0] - 1;
            int toIndex = command[1] - 1;
            int targetIndex = command[2] - 1;
            int[] subArray = new int[toIndex - fromIndex + 1];

            // 3. 인덱스 범위의 요소들 추출하여 배열로 저장
            for(int k = fromIndex; k <= toIndex; k++) {
                int pointer = k - fromIndex;
                subArray[pointer] = array[k];
            }
            // 4. 오름 차순 정렬(버블 정렬)
            bubbleSort(subArray);

            // 5. targetIndex번째 요소 저장
            answer[idx] = subArray[targetIndex];
        }

        return answer;
    }

    private static int[] thirdSolution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        for(int[] command : commands) {
            // 1. 인덱스 범위인 요소만 추출해서 배열 카피
            int[] subArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            // 2. 오름 차순 정렬
            Arrays.sort(subArray);
            answer[index++] = subArray[command[2] - 1];
        }
        return answer;
    }



    private static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}