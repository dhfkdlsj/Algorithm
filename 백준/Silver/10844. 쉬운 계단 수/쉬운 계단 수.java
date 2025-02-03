import java.io.*;

public class Main {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        br.close();

        long[][] dp = new long[N + 1][10];

        // 한 자리 수의 경우 (1~9까지 가능, 0은 제외)
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // DP 진행
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j > 0) dp[i][j] += dp[i - 1][j - 1] % MOD; // j-1로 끝나는 경우
                if (j < 9) dp[i][j] += dp[i - 1][j + 1] % MOD; // j+1로 끝나는 경우
                dp[i][j] %= MOD;
            }
        }

        // 결과 계산
        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + dp[N][i]) % MOD;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
