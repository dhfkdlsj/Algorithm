import java.util.*;
import java.io.*;
public class Main {

    static int N,M,count,total,cnt;
    static int[][] arr;
    static boolean[][] v;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        v = new boolean[N][M];
        count = 0;
        total = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && !v[i][j]) {
                    count++;
                    cnt = 0;
                    dfs(i,j);
                    total = Math.max(total,cnt);
                }
            }
        }
        System.out.println(count);
        System.out.println(total);

        br.close();
    }

    private static void dfs(int i, int j) {
        v[i][j] = true;
        cnt++;
        for (int k = 0; k < 4; k++) {
            int xx = i + dx[k];
            int yy = j + dy[k];
            if (xx >= 0 && yy >= 0 && xx < N && yy < M && !v[xx][yy] && arr[xx][yy] == 1) {
                dfs(xx,yy);
            }
        }
    }
}
