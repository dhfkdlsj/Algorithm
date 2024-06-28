import java.io.*;
import java.util.*;

public class Main {
	static int N,R,S[],b[];
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		R = 6;
		b = new int[R];
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N= Integer.parseInt(st.nextToken());
			
			if(N == 0) {
				System.out.println(sb);
				break;
			}
			
			S = new int[N];
			for(int i=0; i<N; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			perm(0,0);
			sb.append("\n");
		}
	
		br.close();
	}


	static void perm(int cnt,int start) {
		if(cnt == R) {
			for(int i :b)sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		for(int i=start; i<N; i++) {
			b[cnt] = S[i];
			perm(cnt+1,i+1);
		}
	}

}
