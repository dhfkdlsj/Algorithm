import  java.io.*;
import  java.util.*;

public class Main {
	static final int[] di = {-1,0,1,0}; // 상우하좌
	static final int[] dj = {0,1,0,-1};
	static int N,C,R,max,finmax;
	static int[][] a;
	static boolean [][]v;
	
	
	
	static void bfs(int i, int j) {
		ArrayDeque<int []> q = new ArrayDeque<>();
		v[i][j] = true;
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for(int d=0; d<4; d++) {
				int ni = i+di[d];
				int nj = j+dj[d];
				if(0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj] && a[ni][nj] > R) {
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj});
				}
			}
		}
	}
	
	
	
	
	static void dfs(int i, int j) {
		v[i][j] = true;
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj] && a[ni][nj] > R) {
				dfs(ni,nj);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			a = new int[N][N];
			for (int i=0; i<N; i++) { 
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());;
				}
			}
			max = 0;
			finmax=0;
			for (int i=0; i<N; i++) { 
				for(int j=0; j<N; j++) {
					max = Math.max(max, a[i][j]);
				}
			}
			
			
			for(int k=0; k<max;k++) {
				v = new boolean[N][N];
				R=k;
				C = 0;
				for (int i=0; i<N; i++) { 
					for(int j=0;j<N; j++) {
						if (a[i][j] > R && !v[i][j]) {
							dfs(i,j);
							C++;  
						}
					}
				}	
				finmax = Math.max(C, finmax);
			}
			System.out.println(finmax);
		}
	}

