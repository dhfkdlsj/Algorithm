import java.io.*;
import java.util.*;

public class Main {
    static int N, min, max, total;
    static int[] S, O, b;

    static void back(int cnt, int index) {
        if (cnt == N - 1) {
            for(int i=0; i<N-1; i++){
                switch(b[i]) {
                        case 0:
                            total += S[i+1];
                            break;
                        case 1:
                            total -= S[i+1];
                            break;
                        case 2:
                            total *= S[i+1];
                            break;
                        case 3:
                            total /= S[i+1];
                            break;
                    }
            }
            max = Math.max(max,total);
            min = Math.min(min,total);
            total = S[0];
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (O[i] > 0) {
                O[i] -= 1;
                b[index] = i;
                back(cnt + 1, index + 1);
                O[i]+=1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        O = new int[4];
        b = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            O[i] = Integer.parseInt(st.nextToken());
        }
        total = S[0];
        back(0, 0);
        System.out.println(max);
        System.out.println(min);
    }
}
