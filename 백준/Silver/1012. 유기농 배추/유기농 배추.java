import java.util.*;
import java.io.*;

public class Main {
	static int T,M,N,K,X,Y,count;
	static int[][] s;
	static boolean[][] v;
	static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			s = new int[N][M];
			v = new boolean[N][M];
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				s[X][Y] = 1;
			}
			count = 0;
			for(int j = 0; j<N; j++) {
				for(int k = 0; k<M; k++) {
					if(!v[j][k] && s[j][k] == 1) {
						count++;
						dfs(j,k);
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
	static void dfs(int X, int Y) {
		v[X][Y] = true;
		for(int i=0; i<4; i++) {
			int xx = X+dx[i];
			int yy = Y+dy[i];
			if(xx>=0 && yy>=0 && xx<N && yy<M && !v[xx][yy] && s[xx][yy]==1) {
				dfs(xx,yy);
			}
		}
	}

}
