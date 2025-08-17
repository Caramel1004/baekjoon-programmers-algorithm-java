import java.io.*;
import java.util.*;

public class Main {
    static int[] nums;
    static int[][] segTree; // [노드][0=min, 1=max]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        segTree = new int[4 * n][2]; // [][0]=min, [][1]=max
        build(1, 0, n - 1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            int[] result = query(1, 0, n - 1, a, b);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }

        System.out.println(sb);
    }

    // 세그먼트 트리 빌드
    static void build(int node, int start, int end) {
        if (start == end) {
            segTree[node][0] = segTree[node][1] = nums[start];
        } else {
            int mid = (start + end) / 2;
            build(node * 2, start, mid);
            build(node * 2 + 1, mid + 1, end);
            segTree[node][0] = Math.min(segTree[node * 2][0], segTree[node * 2 + 1][0]);
            segTree[node][1] = Math.max(segTree[node * 2][1], segTree[node * 2 + 1][1]);
        }
    }

    // 구간 [l, r] 질의
    static int[] query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        if (l <= start && end <= r) {
            return segTree[node];
        }
        int mid = (start + end) / 2;
        int[] left = query(node * 2, start, mid, l, r);
        int[] right = query(node * 2 + 1, mid + 1, end, l, r);

        return new int[]{
            Math.min(left[0], right[0]),
            Math.max(left[1], right[1])
        };
    }
}