import java.io.*;
import java.util.*;
public class Main {
    static int day, soldier;
    static final int MOD = 1000000007;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        day = Integer.parseInt(st.nextToken());
        soldier = Integer.parseInt(st.nextToken());

        long total = pow(soldier, day, MOD); // 전체 경우의 수 - soldier의 day제곱
        long exclude = pow(soldier -1, day, MOD); // 브실이가 들어가지 않는 경우의 수 (soldier-1)의 day제곱
        long result = (total - exclude + MOD) % MOD; // 전체 경우의 수 - 브실이가 들어가지 않는 경우의 수 = 브실이가 들어가는 경우의 수

        System.out.println(result);
    }

    private static long pow(long base, long exp, int mod) {  // base - 밑, exponent - 제곱수...
        long result = 1;
        while (exp > 0) {
            // 홀수 지수일 경우
            if (exp % 2 == 1) {
                result = (result * base) % mod;  // base를 한 번 더 곱함
                exp--;  // 지수를 1 감소시켜 홀수를 짝수로 만듦
            }

            // 짝수 지수일 경우
            base = (base * base) % mod;  // base를 두 번 곱함
            exp /= 2;  // 지수를 반으로 줄임
        }

        return result;
    }
}
