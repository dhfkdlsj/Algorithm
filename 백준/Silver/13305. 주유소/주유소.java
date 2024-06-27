import java.io.*;
import java.util.*;

public class Main {
	static int N,sum;
	static int[] S,A;
	
	static void oill(int i, int j) {  // i=기름값, j=거리
		if(i == A.length-1) {
			sum += S[i]*j;
			return;
		}
		if(S[i]>=S[i+1]) {
			sum += S[i]*j;
			if(i+1>A.length-1) return;
			else
				oill(i+1,A[i+1]);
		}
		else {
			S[i+1]=S[i];
			oill(i+1,j+A[i+1]);
		}
		return;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N-1];
		S = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());	
		for(int i=0; i<N-1; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());	
		for(int i=0; i<N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		sum = 0;
		oill(0,A[0]);
		System.out.println(sum);
		
	}

}
