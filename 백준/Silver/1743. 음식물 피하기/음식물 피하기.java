import java.util.*;
import java.io.*;

public class Main {
	static int N,M,K,cnt,sum;
	static boolean[][] v;
	static int[][] a;
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken())+1;
		M = Integer.parseInt(st.nextToken())+1;
		K = Integer.parseInt(st.nextToken());
		v = new boolean[N][M];
		a = new int[N][M];
		
		for(int i =0; i< K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[x][y] = 1;
		}
		sum = 0;

		for(int i=1; i<N;i++) {
			for(int j=1; j<M; j++) {
				if(a[i][j] == 1) {
					cnt = 1;
					dfs(i,j);
					sum = Math.max(sum, cnt);
				}
			}
		}
		
		System.out.println(sum);

	}
	static void dfs(int i, int j) {
		v[i][j] = true;
		for(int k=0; k<4; k++) {
			int xx = i+dx[k];
			int yy = j+dy[k];
			if(xx>=1 && yy >= 1 && xx<N && yy<M && !v[xx][yy]&& a[xx][yy]==1) {
				cnt++;
				dfs(xx,yy);
			}
		}
	}
}
