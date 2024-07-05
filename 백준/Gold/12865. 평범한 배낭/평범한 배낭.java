import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		
		for(int i=0; i<N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}

		int[] dp = new int[K+1];

		for(int i=0; i<N; i++) {  
			for(int w=K; w>=1; w--) {
				if(weights[i]<=w) {
					dp[w] = Math.max(dp[w],profits[i]+dp[w-weights[i]]);
				}
			}
		}
		System.out.println(dp[K]);
		sc.close();
	}

}