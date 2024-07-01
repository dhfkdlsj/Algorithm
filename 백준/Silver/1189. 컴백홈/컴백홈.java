import java.io.*;
import java.util.*;

public class Main {
	static int R, C, K, cnt,total;
	static char[][] S;
	static boolean[][] v;
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		v = new boolean[R][C];
		
		S = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				S[i][j] = str.charAt(j);
			}
		}
		total = 0;
		
		v[R-1][0] = true;
		myhome(R-1,0,1);
		System.out.println(total);
	}


	private static void myhome(int x, int y, int cnt) {
		if(x == 0 && y == C-1) {
			if (cnt == K) {
				total++;
			}
			return;
		}
		for (int i=0; i<4; i++) {
			int xx = x+dx[i];
			int yy = y+dy[i];
			if(xx >=0 && yy>=0 && xx<R && yy <C && !v[xx][yy]&&S[xx][yy] != 'T') {
					v[xx][yy] = true;
					myhome(xx,yy,cnt+1);
					v[xx][yy] = false;
			}
		}
	}
}
