import java.io.*;
import java.util.*;

public class Main {
    static int N, S, count;
    static int[] A, b;

    static void sum(int cnt, int start, int R) {
        if (cnt == R) {
            int total = 0;
            for (int i = 0; i < R; i++) {
                total += b[i];
            }
            if (total == S) count++;
            return;
        }
        for (int i = start; i < N; i++) {
            b[cnt] = A[i];
            sum(cnt + 1, i+1, R);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        A = new int[N];
        b = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        count = 0;
        for (int i = 1; i < N + 1; i++) {
            sum(0, 0, i);
        }
        System.out.println(count);
    }
}
