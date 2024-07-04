import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int testCase = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            int[][] S = new int[N][N];
            int[][] dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    S[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, S[0][0]));
            dist[0][0] = S[0][0];

            while (!pq.isEmpty()) {
                Node current = pq.poll();
                int x = current.x;
                int y = current.y;
                int cost = current.cost;

                if (x == N - 1 && y == N - 1) {
                    sb.append("Problem ").append(testCase).append(": ").append(cost).append("\n");
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        int newCost = cost + S[nx][ny];
                        if (newCost < dist[nx][ny]) {
                            dist[nx][ny] = newCost;
                            pq.offer(new Node(nx, ny, newCost));
                        }
                    }
                }
            }
            testCase++;
        }
        System.out.print(sb.toString());
        br.close();
    }
}
