import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,V;
    static List<Integer>[] g;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        g = new List[N+1];
        
        for (int i = 0; i < N+1; i++) {
            g[i] = new ArrayList<>();
        }
        
        v = new boolean[N+1];

        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            g[from].add(to);
            g[to].add(from);
        }
        for(int i=0; i<N+1; i++) {
        	Collections.sort(g[i]);
        }
        dfs(V);
        System.out.println();
        v = new boolean[N+1];
        bfs(V);
    }

    private static void bfs(int i) {
        ArrayDeque<Integer> qu = new ArrayDeque<>();
        v[i] = true;
        qu.offer(i);
        while (!qu.isEmpty()) {
            i = qu.poll();
            System.out.print(i+" ");
            for (int j : g[i]) {
                if (!v[j]) {
                    v[j] = true;
                    qu.offer(j);
                }
            }
        }
    }

    private static void dfs(int i) {
        v[i] = true;
        System.out.print(i+" ");
        for (int j : g[i]) {
            if (!v[j]) {
                dfs(j);
            }
        }
    }
}