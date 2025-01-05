import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] numbers;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = i + 1;
        }
        selected = new int[M];

        sequence(0, 0);

        System.out.println(sb);
        br.close();
    }

    private static void sequence(int start, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            selected[cnt] = numbers[i];
            sequence(i + 1, cnt + 1);
        }
    }
}
