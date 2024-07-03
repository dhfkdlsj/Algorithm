import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정점의 수
        int M = sc.nextInt(); // 간선의 수
        List<int[]>[] g = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) { // 간선의 수 만큼 입력 받음
            int x = sc.nextInt();
            int y = sc.nextInt();
            int c = sc.nextInt();
            g[x].add(new int[] { y, c });
            g[y].add(new int[] { x, c });
        }

        boolean[] v = new boolean[N + 1];
        int[] w = new int[N + 1]; // 프림 알고리즘을 위한 가중치 배열
        Arrays.fill(w, Integer.MAX_VALUE);

        int sum = 0;
        w[1] = 0;
        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;
            int minVertex = -1;
            for (int j = 1; j <= N; j++) {
                if (!v[j] && min > w[j]) {
                    min = w[j];
                    minVertex = j;
                }
            }
            if (minVertex == -1)
                break;
            v[minVertex] = true;
            sum += min;
            for (int[] j : g[minVertex]) {
                if (!v[j[0]] && w[j[0]] > j[1]) {
                    w[j[0]] = j[1];
                }
            }
        }
        System.out.println(sum);

        sc.close();
    }
}
