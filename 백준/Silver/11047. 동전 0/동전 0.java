import java.io.*;
import java.util.*;

public class Main {
	static int N,K,cnt;
	static int[] S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		S = new int[N];
		
		for(int i=0; i<N; i++) {
			S[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=N-1; i>=0; i--) {
			if(K/S[i]>=1) {
				cnt += K/S[i];
				K = K%S[i];
			}
		}
		System.out.println(cnt);
	}

}
