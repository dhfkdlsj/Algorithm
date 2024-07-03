import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] S = new int[N];
		for(int i=0; i<N; i++) {
			S[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(S);
		
		StringBuilder sb = new StringBuilder();
		for(int b:S) sb.append(b).append("\n");
		
		System.out.println(sb);
	}

}
