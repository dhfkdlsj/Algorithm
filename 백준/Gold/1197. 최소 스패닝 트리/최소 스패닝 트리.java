import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // Number of nodes
        int M = sc.nextInt(); // Number of edges
        List<int[]>[] g = new List[N+1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int c = sc.nextInt();
            g[x].add(new int[] { y, c });
            g[y].add(new int[] { x, c });
        }

        boolean[] v = new boolean[N+1];
        int[] w = new int[N+1]; // Weight array for Prim's algorithm
        Arrays.fill(w, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        int sum = 0, cnt = 0;
        w[1] = 0; // Start from node 1
        pq.offer(new int[] {1, 0});

        while (!pq.isEmpty()) {
            int[] vw = pq.poll();
            int minVertex = vw[0];
            int min = vw[1];
            if (v[minVertex]) continue;

            v[minVertex] = true;
            sum += min;

            if (cnt++ == N-1) break;

            for (int[] j : g[minVertex]) {
            	 if(!v[j[0]] && w[j[0]]>j[1]) {
        			 w[j[0]] = j[1];
        			 pq.offer(j);  
        		 }
        	 }
        }
        System.out.println(sum);
        
        sc.close();
    }
}
