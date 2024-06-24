import  java.io.*;
import  java.util.*;

public class Main {
	static final int[] di = {-1,0,1,0,-1,1,-1,1}; // 상우하좌
	static final int[] dj = {0,1,0,-1,1,1,-1,-1};
	static int N,M,C;
	static int[][] a;
	static boolean [][]v;
	
	
	static void dfs(int i, int j) {
		v[i][j] = true;
		for(int d=0; d<8; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(0<=ni && ni<M && 0<=nj && nj<N && !v[ni][nj] && a[ni][nj] == 1) {
				dfs(ni,nj);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if (N==0 && M ==0) {
				break;
			}
			a = new int[M][N];
			v = new boolean[M][N];
			
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			C = 0;
			for (int i=0; i<M; i++) {
				for(int j=0;j<N; j++) {
					if (a[i][j] == 1 && !v[i][j]) {
						dfs(i,j);
						C++;
					}
				}
			}
			sb.append(C).append("\n");
		}
		System.out.println(sb);
	}
}
