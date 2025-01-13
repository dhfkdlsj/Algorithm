import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());
            int[] sangeunArray = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                sangeunArray[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(sangeunArray); // 이진 탐색을 위한 정렬

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int target = Integer.parseInt(st.nextToken());
                int count = upperBound(sangeunArray, target) - lowerBound(sangeunArray, target);
                bw.write(count + " ");
            }
        }
    }

    private static int lowerBound(int[] array, int target) {
        int left = 0;
        int right = array.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if (target <= array[middle]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    private static int upperBound(int[] array, int target) {
        int left = 0;
        int right = array.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if (target < array[middle]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
}