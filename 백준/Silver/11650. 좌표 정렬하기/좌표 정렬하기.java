import java.io.*;
import java.util.*;

public class Main {
	static int N,x,y;
	static int[][] a;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		a = new int[N][2];
		
		for(int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a,(o1,o2)->{return o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1];});
		
		for(int i=0; i<N; i++) {
			System.out.println(a[i][0]+" "+a[i][1]);
		}
	}
}
