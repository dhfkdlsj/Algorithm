import java.io.*;
import java.util.*;

public class Main {
    static int N, M, minBlindSpot;
    static int[][] S;
    static List<CCTV> cctvs = new ArrayList<>();
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
                if (S[i][j] >= 1 && S[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, S[i][j]));
                }
            }
        }

        minBlindSpot = N * M;
        dfs(0);
        System.out.println(minBlindSpot);
    }

    static void dfs(int depth) {
        if (depth == cctvs.size()) {
            minBlindSpot = Math.min(minBlindSpot, countBlindSpots());
            return;
        }

        CCTV cctv = cctvs.get(depth);
        int[][] original = copyArray(S);

        for (int[] dirs : getDirections(cctv.type)) {
            markSurveillance(cctv.x, cctv.y, dirs, true);
            dfs(depth + 1);
            S = copyArray(original);
        }
    }

    static void markSurveillance(int x, int y, int[] dirs, boolean mark) {
        for (int d : dirs) {
            int nx = x;
            int ny = y;
            while (true) {
                nx += directions[d][0];
                ny += directions[d][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || S[nx][ny] == 6) break;
                if (S[nx][ny] == 0) S[nx][ny] = mark ? -1 : 0;
            }
        }
    }

    static int countBlindSpots() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (S[i][j] == 0) count++;
            }
        }
        return count;
    }

    static int[][] copyArray(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }

    static int[][] getDirections(int type) {
        switch (type) {
            case 1:
                return new int[][]{{0}, {1}, {2}, {3}};
            case 2:
                return new int[][]{{0, 1}, {2, 3}};
            case 3:
                return new int[][]{{0, 2}, {0, 3}, {1, 2}, {1, 3}};
            case 4:
                return new int[][]{{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}};
            case 5:
                return new int[][]{{0, 1, 2, 3}};
        }
        return new int[][]{};
    }

    static class CCTV {
        int x, y, type;

        CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
