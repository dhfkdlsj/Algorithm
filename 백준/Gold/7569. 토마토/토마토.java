import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H; // 가로, 세로, 높이
    static int[][][] box;
    static boolean[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0, 0, 0}; // x축 이동 (좌우)
    static int[] dy = {0, 0, 1, -1, 0, 0}; // y축 이동 (위아래)
    static int[] dz = {0, 0, 0, 0, 1, -1}; // z축 이동 (높이)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로 (열)
        N = Integer.parseInt(st.nextToken()); // 세로 (행)
        H = Integer.parseInt(st.nextToken()); // 높이 (층)

        box = new int[H][N][M];
        visited = new boolean[H][N][M];

        // 입력 받으면서 익은 토마토 찾기
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == 1) {
                        queue.offer(new int[]{h, n, m, 0}); // 초기 익은 토마토 저장 (층, 행, 열, 일수 - 0일차 1일차)
                        visited[h][n][m] = true;
                    }
                }
            }
        }

        System.out.println(bfs()); // BFS 수행 후 결과 출력
    }

    static int bfs() {
        int days = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int z = current[0], y = current[1], x = current[2], day = current[3];
            days = Math.max(days, day);

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (nz >= 0 && nz < H && ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (!visited[nz][ny][nx] && box[nz][ny][nx] == 0) {
                        visited[nz][ny][nx] = true;
                        box[nz][ny][nx] = 1;
                        queue.offer(new int[]{nz, ny, nx, day + 1});
                    }
                }
            }
        }

        // BFS 끝나고 익지 않은 토마토가 있는지 검사
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) return -1; // 익지 않은 토마토가 남아있다면 -1 반환
                }
            }
        }

        return days;
    }
}
