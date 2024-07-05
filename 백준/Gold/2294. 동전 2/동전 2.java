import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
        int S[] = new int[N];
        int dp[] = new int[M+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	S[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int coin:S) {
        	for(int j=coin; j<=M; j++) {
        		if(dp[j-coin]!= Integer.MAX_VALUE) {
        			dp[j] = Math.min(dp[j],dp[j-coin]+1);
        		}
        	}
        }
        if(dp[M]== Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[M]);
	}

}
