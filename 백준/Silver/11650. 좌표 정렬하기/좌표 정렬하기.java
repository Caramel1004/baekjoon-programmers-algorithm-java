import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coordinates.add(new Coordinate(x, y));
        }

        coordinates.sort(
                Comparator.comparingInt((Coordinate c) -> c.x)
                        .thenComparingInt((Coordinate c) -> c.y)
        );

        coordinates.forEach(coordinate -> sb.append(coordinate.x).append(" ").append(coordinate.y).append("\n"));
        
        System.out.println(sb);
    }
}