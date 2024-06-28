import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int totalMoves = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            boolean moved = false;
            visited = new boolean[N][N];

            // 인구 이동을 위한 BFS 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            moved = true; // 인구 이동이 발생했음을 표시
                        }
                    }
                }
            }

            if (!moved) {
                break; // 더 이상 인구 이동이 없으면 종료
            }

            totalMoves++; // 인구 이동이 발생했으므로 이동 횟수 증가
        }

        System.out.println(totalMoves);
    }

    static boolean bfs(int si, int sj) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>();
        queue.offer(new int[]{si, sj});
        visited[si][sj] = true;
        union.add(new int[]{si, sj});
        int totalPopulation = map[si][sj];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int ci = current[0];
            int cj = current[1];

            for (int d = 0; d < 4; d++) {
                int ni = ci + di[d];
                int nj = cj + dj[d];

                if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visited[ni][nj]) {
                    int diff = Math.abs(map[ni][nj] - map[ci][cj]);
                    if (diff >= L && diff <= R) {
                        visited[ni][nj] = true;
                        queue.offer(new int[]{ni, nj});
                        union.add(new int[]{ni, nj});
                        totalPopulation += map[ni][nj];
                    }
                }
            }
        }

        if (union.size() > 1) { // 연합이 형성되었을 경우
            int newPopulation = totalPopulation / union.size();
            for (int[] country : union) {
                map[country[0]][country[1]] = newPopulation;
            }
            return true; // 인구 이동이 발생했음을 반환
        }

        return false; // 인구 이동이 없었음을 반환
    }
}
