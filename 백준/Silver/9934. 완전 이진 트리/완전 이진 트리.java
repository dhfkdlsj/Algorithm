import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] a;
	static ArrayList<Integer>[] tree;
	
	static void real(int depth,int tnc, int cnt) {
		if (depth>N) return;
		
		int n = (cnt+tnc)/2;
		tree[depth].add(a[n]);
		real(depth+1,tnc,n-1);
		real(depth+1,n+1,cnt);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = (int) ((Math.pow(2, N))-1);
		a = new int[M];
		
		 tree = new ArrayList[N + 1];
	        
	        for (int i = 1; i <= N; i++) {
	            tree[i] = new ArrayList<>();
	        }
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		real(1,0,M-1);
		
		for (int i = 1; i <= N; i++) {
            for (int value : tree[i]) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
	}
}
