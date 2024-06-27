import java.io.*;
import java.util.*;

public class Main {
	static int N,sum,val;
	static int[] S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());	
		for(int i=0; i<N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(S);
		
		sum = 0;
		for(int i:S) {
			sum += i;
			val +=sum;
		}
		System.out.println(val);
	}

}
