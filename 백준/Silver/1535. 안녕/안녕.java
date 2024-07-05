import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] sad = new int[N+1];
		int[] happy = new int[N+1];
		
		for(int i=0; i<N; i++) {
			sad[i] = sc.nextInt();
		}
		for(int i=0; i<N; i++) {
			happy[i] = sc.nextInt();
		}

		int[] dp = new int[100];

		for(int i=0; i<N; i++) {   // 제로 원 -> 없거나 1개 있을때  -> 3키로 1개 4키로 1개 넣어서 90 나옴
			for(int w=99; w>=1; w--) {
				if(sad[i]<=w) {
					dp[w] = Math.max(dp[w],happy[i]+dp[w-sad[i]]);
				}
			}
		}
		System.out.println(dp[99]);
		sc.close();
	}

}