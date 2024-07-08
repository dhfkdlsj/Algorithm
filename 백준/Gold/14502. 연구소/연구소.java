import java.util.*;
import java.io.*;

class Node{
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N,M,safe;
	static int[][] S;
	static ArrayList<Node> list = new ArrayList<>();
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static int[][] copyArray(int[][] original) { 
	    int[][] copy = new int[original.length][];
	    for (int i = 0; i < original.length; i++) {
	        copy[i] = original[i].clone();
	    }
	    return copy;
	}
	
	static void dfs(int depth) {
		if(depth == list.size()) {
			safe = Math.max(safe, countSafe());
			return;
		}
		Node node = list.get(depth);
		int[][] original = copyArray(S);
		
		virus(node.x,node.y);
		dfs(depth+1);
		S = copyArray(original);
	}
	
	static void virus(int x, int y) {
		for(int i=0; i<4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx >=0 && yy >= 0 && xx < N && yy < M && S[xx][yy]== 0) {
				S[xx][yy] = 2;
				virus(xx,yy);
			}
		}
	}

	private static int countSafe() {
		int count = 0;
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {   
                if (S[i][j] == 0) count++;
            }
        }
		return count;
	}

	static void perm(int cnt,int start) {
		if(cnt == 3) {
			dfs(0);
			return;
		}
		for (int i = start; i < N * M; i++) {
	        int x = i / M;
	        int y = i % M;
	        if (S[x][y] == 0) {
	            S[x][y] = 1;
	            perm(cnt + 1, i + 1);
	            S[x][y] = 0;
	        }
	    }
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		S = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int c = Integer.parseInt(st.nextToken());
				S[i][j] = c;
				if(c == 2) list.add(new Node(i,j));
			}
		}
		safe = 0;
		perm(0,0);
		System.out.println(safe);
	}
}
