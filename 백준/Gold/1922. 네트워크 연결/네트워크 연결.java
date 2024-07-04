import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<int[]>[] g = new List[N];
		for (int i = 0; i < N; i++)
			g[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			g[x].add(new int[] { y, z });
			g[y].add(new int[] { x, z });
		}

		boolean[] v = new boolean[N];
		int[] w = new int[N]; // 프림w[]
		Arrays.fill(w, Integer.MAX_VALUE);

		int sum = 0, cnt = 0;
		w[0] = 0;
		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int j = 0; j < N; j++) {
				if (!v[j] && min > w[j]) {
					min = w[j];
					minVertex = j;
				}
			}

			v[minVertex] = true;
			sum += min;
			if (cnt++ == N - 1)
				break;
			for (int[] j : g[minVertex]) {
				if (!v[j[0]] && w[j[0]] > j[1]) {
					w[j[0]] = j[1];
				}
			}
		}
		System.out.println(sum);
		br.close();
	}
}