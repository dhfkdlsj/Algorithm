import java.io.*;
import java.util.*;

public class Main {
	static int N,R,S[],b[];
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		b = new int[R];
		v = new boolean[N];
		
		S = new int[N];
		for(int i=0; i<N; i++) {
			S[i] = i+1;
		}
		perm(0);
		System.out.println(sb);
	
		br.close();
	}

	static void perm(int cnt) {
		if(cnt == R) {
			for(int i :b)sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			if(v[i]) continue;
			v[i] = true;
			b[cnt] = S[i];
			perm(cnt+1);
			v[i] = false;
		}
	}

}
