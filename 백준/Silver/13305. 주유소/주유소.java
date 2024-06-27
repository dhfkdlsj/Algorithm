import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long sum;
    static int[] S, A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N-1];
        S = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N-1; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        
        sum = 0;
        int minPrice = S[0];
        
        for(int i = 0; i < N-1; i++) {
            if(S[i] < minPrice) {
                minPrice = S[i];
            }
            sum += (long) minPrice * A[i];
        }
        
        System.out.println(sum);
    }
}
