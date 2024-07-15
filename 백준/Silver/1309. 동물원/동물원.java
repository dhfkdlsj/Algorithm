import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] S = new int[2];
		S[0] = 1;
		S[1] = 3;

		for (int i = 2; i <= N; i++) {
			if(i%2 ==0)
		        S[0] = (2* S[1]+S[0])%9901;
		    else
		        S[1] = (2*S[0] + S[1])%9901;
		}
		
		System.out.println(S[N%2]);

	}

}
