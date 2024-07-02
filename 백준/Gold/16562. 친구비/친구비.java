import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[] parent, cost;

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            if (rootA < rootB) {
                parent[rootB] = rootA;
            } else {
                parent[rootA] = rootB;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        cost = new int[N + 1];
        
        // Initialize parent array for union-find
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        
        // Read costs
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        // Union-find operations based on given friendships
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        // Find the minimum cost among each group
        int[] minCost = new int[N + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        for (int i = 1; i <= N; i++) {
            int root = find(i);
            minCost[root] = Math.min(minCost[root], cost[i]);
        }

        // Calculate the total minimum cost required
        long totalCost = 0;
        for (int i = 1; i <= N; i++) {
            if (minCost[i] != Integer.MAX_VALUE) {
                totalCost += minCost[i];
            }
        }

        // Check if the total cost is within the budget
        if (totalCost > K) {
            System.out.println("Oh no");
        } else {
            System.out.println(totalCost);
        }

        br.close();
    }
}
