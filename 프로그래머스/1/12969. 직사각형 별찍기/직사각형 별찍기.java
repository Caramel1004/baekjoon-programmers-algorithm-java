import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArr = br.readLine().split(" ");
        
        int starCount = Integer.parseInt(inputArr[0]); // 별 갯수
        int repeatCount = Integer.parseInt(inputArr[1]); // 반복 출력 횟수
        
        StringBuilder sb = new StringBuilder();

        sb.append("*".repeat(starCount)); // * 스택
        sb.append("\n");
        
        /* StringBuilder -> String 
         * repeatCount만큼 반
        */
        System.out.println(String.join("", sb).repeat(repeatCount));
    }
}