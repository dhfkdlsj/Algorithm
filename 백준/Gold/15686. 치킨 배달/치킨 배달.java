import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<int[]> ones = new ArrayList<>();
        List<int[]> twos = new ArrayList<>();

        // 배열에서 1과 2의 위치를 찾기
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    ones.add(new int[]{i, j});
                } else if (grid[i][j] == 2) {
                    twos.add(new int[]{i, j});
                }
            }
        }

        // M개의 2를 선택하는 모든 조합에 대해 최소 거리를 계산
        int minTotalDistance = findMinTotalDistance(twos, ones, M);

        System.out.println(minTotalDistance);
    }

    // 주어진 2들의 리스트에서 M개를 선택하는 조합을 통해 최소 거리를 계산
    public static int findMinTotalDistance(List<int[]> twos, List<int[]> ones, int M) {
        int[] minTotalDistance = { Integer.MAX_VALUE };  // 배열로 감싸서 참조로 전달
        combination(twos, new int[M], 0, 0, ones, minTotalDistance);
        return minTotalDistance[0];
    }

    // 조합을 생성하는 함수
    public static void combination(List<int[]> twos, int[] selected, int start, int depth, List<int[]> ones, int[] minTotalDistance) {
        if (depth == selected.length) {
            // 선택된 M개의 2에 대해 최소 거리를 계산
            int currentDistance = calculateMinDistance(ones, twos, selected);
            if (currentDistance < minTotalDistance[0]) {
                minTotalDistance[0] = currentDistance;
            }
            return;
        }

        for (int i = start; i < twos.size(); i++) {
            selected[depth] = i;
            combination(twos, selected, i + 1, depth + 1, ones, minTotalDistance);
        }
    }

    // 선택된 M개의 2에 대해 최소 거리를 계산하는 함수
    public static int calculateMinDistance(List<int[]> ones, List<int[]> twos, int[] selected) {
        int totalMinDistance = 0;

        for (int[] one : ones) {
            int minDistance = Integer.MAX_VALUE;
            for (int index : selected) {
                int[] two = twos.get(index);
                int distance = Math.abs(one[0] - two[0]) + Math.abs(one[1] - two[1]);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
            totalMinDistance += minDistance;
        }

        return totalMinDistance;
    }
}
