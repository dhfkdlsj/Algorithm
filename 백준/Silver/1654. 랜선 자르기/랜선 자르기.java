import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cables = new int[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, cables[i]);
        }

        long left = 1, right = max, answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int cable : cables) {
                count += cable / mid;
            }

            if (count >= N) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
