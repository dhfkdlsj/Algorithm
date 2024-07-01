import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int R, C, result;
	static int[][] S;
	static boolean[][] v;
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	static Point p = new Point(); 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		v = new boolean[R][C];
		
		S = new int[R][C];
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				S[i][j] = str.charAt(j)-48;
			}
		}
		result = myhome(0,0);
		System.out.println(result);
	}


	static int myhome(int x, int y) {
		Deque<Point> dq = new ArrayDeque<>();
		dq.add(new Point(x,y));
		v[x][y] = true;
		while(!dq.isEmpty()) {
			Point w = dq.poll();
			for (int i=0; i<4; i++) {
				int xx = w.x+dx[i];
				int yy = w.y+dy[i];
				if(xx >=0 && yy>=0 && xx<R && yy <C && !v[xx][yy]&& S[xx][yy] != 0) {
					dq.add(new Point(xx,yy));
					v[xx][yy] = true;
					S[xx][yy] = S[w.x][w.y] + 1;
					 if (xx == R - 1 && yy == C - 1) {
	                        return S[xx][yy];
	                    }
				}
		}
}	return -1;
}
}
