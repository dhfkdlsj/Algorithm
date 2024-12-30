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

        for (int i = n / 3; i >= 0; i--) {
            int remaining = n - 3 * i;
            if (remaining % 5 == 0) {
                minSum = Math.min(minSum, i + remaining / 5);
            }
        }

        System.out.println(minSum == Integer.MAX_VALUE ? -1 : minSum);
    }

}
