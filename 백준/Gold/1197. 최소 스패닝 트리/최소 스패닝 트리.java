import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] g;
	static int[] p;
	
	static void make() {
		p =new int[N];
		for(int i=1; i<N; i++) p[i] = i;
	}
	static int find(int a) {
		if(p[a]==a) return a;
		return find(p[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return false;
		p[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt()+1;
		int E=sc.nextInt();
		g = new int[E][3];
		
		for(int i=0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			g[i] = new int[] {from,to,cost};
		}
		Arrays.sort(g,(o1,o2)->Integer.compare(o1[2], o2[2]));
		make();
		int sum =0, cnt=0;
		for(int[]e:g) {
			if(union(e[0],e[1])) {
				sum+= e[2];
				if(++cnt==N-1) break;
			}
		}
		System.out.println(sum);
		
		sc.close();
	}

}
