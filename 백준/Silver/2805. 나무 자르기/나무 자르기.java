import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무의 개수
        int M = Integer.parseInt(st.nextToken()); // 필요한 나무 길이

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > max) {
                max = trees[i]; // 가장 높은 나무 찾기
            }
        }

        // 이분 탐색
        int low = 0, high = max;
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long sum = 0; // 자른 나무 길이의 합

            for (int tree : trees) {
                if (tree > mid) {
                    sum += (tree - mid);
                }
            }

            if (sum >= M) { // 충분한 나무를 얻었으면 더 높은 곳에서 자름
                result = mid; 
                low = mid + 1;
            } else { // 부족하면 낮은 곳에서 자름
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}
