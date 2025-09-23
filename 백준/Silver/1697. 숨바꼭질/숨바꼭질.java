import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;

    static int[] visited = new int[100001]; // 0 ~ 100000

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = bfs(N);
        System.out.println(result);
    }

    private static int bfs(int node) {
        Arrays.fill(visited, -1); // -1: 미방문
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = 0; // 시작 거리는 0

        while (!queue.isEmpty()) {
            int location = queue.poll();

            if (location == K) return visited[location];

            int[] next = { location - 1, location + 1, location * 2 };
            for (int nx : next) {
                if (0 <= nx && nx < visited.length && visited[nx] == -1) { // '<'와 -1 체크
                    visited[nx] = visited[location] + 1;
                    queue.offer(nx);
                }
            }
        }
        return -1;
    }
}