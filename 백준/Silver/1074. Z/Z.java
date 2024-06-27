import java.io.*;
import java.util.*;

public class Main {
    static int N, R, C, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int size = 1 << N; // 2^N
        System.out.println(findZ(size, R, C));
    }

    static int findZ(int size, int r, int c) {
        if (size == 1) {
            return 0;
        }

        int newSize = size / 2;
        if (r < newSize && c < newSize) { // 1st quadrant
            return findZ(newSize, r, c);
        } else if (r < newSize && c >= newSize) { // 2nd quadrant
            return newSize * newSize + findZ(newSize, r, c - newSize);
        } else if (r >= newSize && c < newSize) { // 3rd quadrant
            return 2 * newSize * newSize + findZ(newSize, r - newSize, c);
        } else { // 4th quadrant
            return 3 * newSize * newSize + findZ(newSize, r - newSize, c - newSize);
        }
    }
}
