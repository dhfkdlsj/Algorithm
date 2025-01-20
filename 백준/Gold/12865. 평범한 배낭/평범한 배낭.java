import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] weights = new int[N+1];
        int[] profits = new int[N+1];
        
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            profits[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[K+1];
        
        for (int i=0; i<N; i++){
            for (int w=K; w>=1; w--) {
                if (weights[i]<=w) {
                    dp[w] = Math.max(dp[w],profits[i]+dp[w-weights[i]]);
                }
            }
        }

        System.out.println(dp[K]);
        br.close();

    }
}
