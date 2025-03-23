
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        long start = 1, end = M;
        long ans = 0;

        while (start <= end) {
            long middle = (start + end) / 2;
            long cnt = 0;
            for ( int i = 1; i <= N; i++) {
                cnt += Math.min(middle/i,N);
            }
            if(cnt < M) {
                start = middle + 1;
            }
            else {
                ans = middle;
                end = middle - 1;
            }
        }
        System.out.println(ans);
    }
}
