import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int minSum = Integer.MAX_VALUE;

        if (n % 3 == 0)
            minSum = Math.min(minSum, n/3);
        if (n % 5 == 0)
            minSum = Math.min(minSum, n/5);

        int a = n / 3;
        for (int i = 1; i < a; i++) {
            int sum = 3 * (a-i) + 5;
            if (sum == n) {
                minSum = Math.min(minSum, a-i+1);
            }
            int x = 0;
            while (sum < n){
                sum += 5;
                x++;
                if (sum == n) {
                    minSum = Math.min(minSum, a-i+1+x);
                    break;
                }
            }
        }

        if (minSum == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(minSum);
    }

}
