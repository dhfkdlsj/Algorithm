import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] a, b;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N];
        b = new int[M];
        for (int i = 0; i < N; i++) {
            a[i] = i+1;
        }
        v = new boolean[N];

        perm(0);
        System.out.println(sb);

        br.close();
    }

    private static void perm(int cnt) {
        if (cnt == M) {
            for(int i : b){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (v[i]) continue;
            v[i] = true;
            b[cnt] = a[i];
            perm(cnt+1);
            v[i] = false;
        }
    }
}

