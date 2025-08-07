import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);

        int count = 0;

        for(int i = 0; i < N; i++) {
            long target = A[i];
            int start = 0;
            int end = N - 1;

            while(start < end) {
                if(start == i) {
                    start++;
                    continue;
                }
                if(end == i) {
                    end--;
                    continue;
                }

                long sum = A[start] + A[end];

                if(sum == target) {
                    count++;
                    break;
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.println(count);
    }
}
