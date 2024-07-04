import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine()) - 1;
		List<int[]>[] g = new List[V];
		for (int i = 0; i < V; i++)
			g[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			g[x].add(new int[] { y, z });
		}

		boolean[] v = new boolean[V];
		int[] w = new int[V];
		Arrays.fill(w, Integer.MAX_VALUE);

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		w[K] = 0;
		pq.offer(new int[] { K, w[K] });
		while (!pq.isEmpty()) {
			int[] vw = pq.poll();
			int minVertex = vw[0];
			if(v[minVertex]) continue;
			
			v[minVertex] = true;
			
			for (int[] j : g[minVertex]) {
				if (!v[j[0]] && w[j[0]] > w[minVertex] + j[1]) {
					w[j[0]] = w[minVertex] + j[1];
					pq.offer(new int[]{j[0],w[j[0]]});	
				}
			}
		}
		for(int i=0; i<V; i++) {
			if(w[i]== Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else{
				System.out.println(w[i]);
			}
		}
		br.close();
	}

}
