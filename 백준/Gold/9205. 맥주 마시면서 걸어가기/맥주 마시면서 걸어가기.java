import java.io.*;
import java.util.*;

class Point {
    final int x, y;
    Point(int x, int y) { this.x = x; this.y = y; }
}

public class Main {

    static int manhattan(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            // points[0]=집, 1..N=편의점, N+1=페스티벌
            Point[] points = new Point[N + 2];
            for (int i = 0; i < N + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i] = new Point(x, y);
            }

            boolean[] visited = new boolean[N + 2];
            Deque<Integer> q = new ArrayDeque<>();
            q.offer(0);
            visited[0] = true;

            boolean canReach = false;
            while (!q.isEmpty()) {
                int cur = q.poll();

                // 현재 위치에서 바로 페스티벌까지 갈 수 있으면 종료
                if (manhattan(points[cur], points[N + 1]) <= 1000) {
                    canReach = true;
                    break;
                }

                // 아직 안 들른 편의점 중, 한 번에 갈 수 있는 곳 탐색
                for (int i = 1; i <= N; i++) {
                    if (!visited[i] && manhattan(points[cur], points[i]) <= 1000) {
                        visited[i] = true;
                        q.offer(i);
                    }
                }
            }

            out.append(canReach ? "happy" : "sad").append('\n');
        }

        System.out.print(out);
    }
}