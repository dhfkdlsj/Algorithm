import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int maxSum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        blackjack(0,0,0);
        System.out.println(maxSum);

    }

    private static void blackjack(int start, int cnt, int totalSum) {
        if (cnt == 3) {
            if (totalSum <= M){
                maxSum = Math.max(maxSum, totalSum);
            }
            return;
        }
        for (int i = start; i < N; i++) {
            blackjack(i+1, cnt+1, totalSum+arr[i]);
        }
    }
}
