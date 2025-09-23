import java.io.*;
import java.util.*;

public class Main {

    static int N,M, d,count, r, c;
    static int[] dx = {-1, 0, 1, 0}; // 배열은 행렬이라 [dy][dx]가 되므로 dx = -1, dy = 0의 경우가 북쪽임, 반대 적용이라 생각
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean();

        System.out.println(count);

    }

    private static void clean() {
        while(true) {
            // 1. 현재 칸 청소
            if (map[r][c] == 0) {
                map[r][c] = 2;
                count++;
            }

            boolean moved = false;

            // 2. 4방향 탐색
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 왼쪽 회전
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0) {
                        // 청소 안한칸 있으면 전진
                        r = nx;
                        c = ny;
                        moved = true;
                        break;
                    }
                }
            }
            if(!moved) {
                int back = (d + 2) % 4;
                int bx = r + dx[back];
                int by = c + dy[back];

                if (bx >= 0 && bx < N && by >= 0 && by < M && map[bx][by] != 1) {
                    r = bx;
                    c = by;
                } else {
                    // 후진 불가능 (벽)
                    break;
                }
            }
        }
    }

}