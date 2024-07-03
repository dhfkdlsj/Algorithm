import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		List<int[]>[] g = new List[N+1];
		for (int i = 1; i < N+1; i++) {
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
		int[] w = new int[N+1]; // 프림w[]
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